package me.bossm0n5t3r.leetcodegen

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

object LeetCodeHelper {
    private val packageDeclarationRegex =
        Regex("""(?m)^package[ \t]+([A-Za-z_][A-Za-z0-9_.]*)[ \t]*$""")

    private val regex = Regex("[^a-zA-Z0-9]")
    private val leadingDigitsRegex = Regex("""^\d+""")
    private val digitWords =
        arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

    fun String.toLowerCase() =
        this.substringAfter(". ").replaceLeadingDigits().replace(regex, "").lowercase()

    private fun String.replaceLeadingDigits(): String {
        val leadingDigits = leadingDigitsRegex.find(this)?.value ?: return this
        val digitPrefix = buildString {
            leadingDigits.forEachIndexed { index, digit ->
                if (index > 0) append(' ')
                append(digitWords[digit.digitToInt()])
            }
        }
        val remainder = removePrefix(leadingDigits).trimStart()
        return if (remainder.isEmpty()) digitPrefix else "$digitPrefix $remainder"
    }

    private fun String.replaceRomanNumeralsAndSpecialCharacters() =
        this.replace("IV", "I V").replace("III", "I I I").replace("II", "I I").replace(regex, " ")

    fun String.toPascalCase(): String {
        return this.substringAfter(". ")
            .replaceLeadingDigits()
            .replaceRomanNumeralsAndSpecialCharacters()
            .trim()
            .split(" ")
            .joinToString("") { s ->
                if (s.all { it.isUpperCase() }) {
                    return@joinToString s
                }
                s.lowercase().replaceFirstChar { it.uppercase() }
            }
    }

    fun Path.normalizeExistingPackageToLowercase(): Path {
        val lowercasePath = resolveSibling(fileName.toString().lowercase())
        val matchingDirectories =
            parent
                .toFile()
                .listFiles { file ->
                    file.isDirectory &&
                        file.name.equals(lowercasePath.fileName.toString(), ignoreCase = true)
                }
                .orEmpty()

        if (matchingDirectories.isEmpty()) return lowercasePath
        check(matchingDirectories.size == 1) {
            "Multiple package paths match ${lowercasePath.fileName}: " +
                matchingDirectories.joinToString { it.name }
        }

        val existingPath = matchingDirectories.single().toPath()
        existingPath.updatePackageDeclarationsToLowercase(lowercasePath.fileName.toString())
        if (existingPath.fileName.toString() == lowercasePath.fileName.toString())
            return lowercasePath

        val projectRoot = Paths.get("").toAbsolutePath().normalize()
        val trackedByGit = existingPath.isTrackedByGit(projectRoot)
        val temporaryPath =
            existingPath.resolveSibling(".${lowercasePath.fileName}-${System.nanoTime()}")
        movePackagePath(existingPath, temporaryPath, projectRoot, trackedByGit)
        try {
            movePackagePath(temporaryPath, lowercasePath, projectRoot, trackedByGit)
        } catch (exception: Exception) {
            try {
                movePackagePath(temporaryPath, existingPath, projectRoot, trackedByGit)
            } catch (rollbackException: Exception) {
                exception.addSuppressed(rollbackException)
            }
            throw exception
        }

        val moveMethod = if (trackedByGit) "git mv" else "filesystem move"
        println(
            "Package path renamed with $moveMethod: " +
                "${existingPath.toAbsolutePath()} -> ${lowercasePath.toAbsolutePath()}"
        )
        return lowercasePath
    }

    private fun Path.updatePackageDeclarationsToLowercase(lowercasePackageSegment: String) {
        toFile()
            .walkTopDown()
            .filter { file -> file.isFile && file.extension == "kt" }
            .forEach { file ->
                val content = file.readText()
                val match = packageDeclarationRegex.find(content) ?: return@forEach
                val packageName = match.groupValues[1]
                val packageSegment = packageName.substringAfterLast('.')
                if (
                    packageSegment == lowercasePackageSegment ||
                        !packageSegment.equals(lowercasePackageSegment, ignoreCase = true)
                ) {
                    return@forEach
                }

                val packagePrefix = packageName.substringBeforeLast('.', missingDelimiterValue = "")
                val lowercasePackageName =
                    if (packagePrefix.isEmpty()) {
                        lowercasePackageSegment
                    } else {
                        "$packagePrefix.$lowercasePackageSegment"
                    }
                val packageNameRange = checkNotNull(match.groups[1]).range
                file.writeText(content.replaceRange(packageNameRange, lowercasePackageName))
                println("Package declaration updated: ${file.absolutePath}")
            }
    }

    private fun Path.isTrackedByGit(projectRoot: Path): Boolean {
        val relativePath = projectRoot.relativize(toAbsolutePath().normalize()).toString()
        val process =
            ProcessBuilder("git", "ls-files", "--error-unmatch", "--", relativePath)
                .directory(projectRoot.toFile())
                .redirectErrorStream(true)
                .start()
        process.inputStream.bufferedReader().use { it.readText() }
        return process.waitFor() == 0
    }

    private fun movePackagePath(
        source: Path,
        target: Path,
        projectRoot: Path,
        trackedByGit: Boolean,
    ) {
        if (!trackedByGit) {
            Files.move(source, target)
            return
        }

        val sourcePath = projectRoot.relativize(source.toAbsolutePath().normalize()).toString()
        val targetPath = projectRoot.relativize(target.toAbsolutePath().normalize()).toString()
        val process =
            ProcessBuilder("git", "mv", "--", sourcePath, targetPath)
                .directory(projectRoot.toFile())
                .redirectErrorStream(true)
                .start()
        val output = process.inputStream.bufferedReader().use { it.readText() }.trim()
        check(process.waitFor() == 0) {
            "git mv failed: $sourcePath -> $targetPath" +
                output.takeIf { it.isNotEmpty() }?.let { "\n$it" }.orEmpty()
        }
    }
}
