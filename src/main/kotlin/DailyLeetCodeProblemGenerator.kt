import LeetCodeHelper.toLowerCase
import LeetCodeHelper.toPascalCase
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.exists
import kotlinx.coroutines.runBlocking

object DailyLeetCodeProblemGenerator {
    private val packageDeclarationRegex =
        Regex("""(?m)^package[ \t]+([A-Za-z_][A-Za-z0-9_.]*)[ \t]*$""")

    fun generateProblem(
        rawInput: String = "",
        recreateExistingProblem: Boolean = true,
        recreateExistingTest: Boolean = true,
    ) {
        val titleSlug = rawInput.toTitleSlug()
        if (titleSlug.isBlank()) {
            run(recreateExistingProblem, recreateExistingTest)
        } else {
            run(titleSlug, recreateExistingProblem, recreateExistingTest)
        }
    }

    private fun String.toTitleSlug(): String {
        val trimmed = this.trim()
        return if ("/problems/" in trimmed) {
            trimmed.substringAfter("/problems/").substringBefore("/").substringBefore("?")
        } else {
            trimmed
        }
    }

    private fun Path.normalizeExistingPackageToLowercase(): Path {
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

    private fun run(recreateExistingProblem: Boolean, recreateExistingTest: Boolean) {
        with(readProblem()) {
            println()
            println("Problem: $name")
            println("URL: $url")
            println()
            createFiles(recreateExistingProblem)
            createTest(recreateExistingTest)
            println("Done!")
        }
    }

    private fun run(
        titleSlug: String,
        recreateExistingProblem: Boolean,
        recreateExistingTest: Boolean,
    ) {
        with(readProblem(titleSlug)) {
            println()
            println("Problem: $name")
            println("URL: $url")
            println()
            createFiles(recreateExistingProblem)
            createTest(recreateExistingTest)
            println("Done!")
        }
    }

    private fun readProblem(): Problem {
        val problem = runBlocking { LeetCodeClient.getDailyLeetCodeProblem() }
        return Problem(
            name = problem.name,
            url = problem.url,
            sampleCodes = problem.sampleCodes,
            methodParametersAndResultAsString = problem.methodParametersAndResultAsString,
            exampleTestcases = problem.exampleTestcases,
            filePath = problem.name.toLowerCase(),
        )
    }

    private fun readProblem(titleSlug: String): Problem {
        val problem = runBlocking { LeetCodeClient.getLeetCodeProblemByTitleSlug(titleSlug) }
        return Problem(
            name = problem.name,
            url = problem.url,
            sampleCodes = problem.sampleCodes,
            methodParametersAndResultAsString = problem.methodParametersAndResultAsString,
            exampleTestcases = problem.exampleTestcases,
            filePath = problem.name.toLowerCase(),
        )
    }

    private fun Problem.createFiles(recreateExistingProblem: Boolean) {
        val (name, url, sampleCodes, _, _, filePath) = this
        val newProblemPath =
            Paths.get(problemPath.toString(), filePath).normalizeExistingPackageToLowercase()
        try {
            if (newProblemPath.exists()) {
                if (!recreateExistingProblem) {
                    println("Existing problem kept. Skipping problem generation.")
                    return
                }
                println("Problem already exists. Recreating...")
                newProblemPath.toFile().deleteRecursively()
                println("Previous problem deleted!")
                println()
            }

            newProblemPath.toFile().mkdirs()
            println("Created directory: ${newProblemPath.toAbsolutePath()}\n")

            // Create README.md
            File(newProblemPath.toString(), "README.md")
                .writeText(
                    """
                # $name
                
                - [$url]($url)
                
                """
                        .trimIndent()
                )

            // Create Problem
            val pascalCaseProblemName = name.toPascalCase()
            val sampleCodeString =
                sampleCodes.joinToString("\n") {
                    if (it.isNotEmpty()) {
                        "    ${it.ifBlank { "${it}TODO()" }}"
                    } else {
                        ""
                    }
                }
            File(newProblemPath.toString(), "$pascalCaseProblemName.kt")
                .writeText(
                    "package me.bossm0n5t3r.leetcode.$filePath\n\n" +
                        "class $pascalCaseProblemName {\n" +
                        "${sampleCodeString}\n" +
                        "}\n"
                )
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }

    private fun Problem.createTest(recreateExistingTest: Boolean) {
        val (name, _, _, methodParametersAndResultAsString, exampleTestcases, filePath) = this
        val newTestPath =
            Paths.get(testPath.toString(), filePath).normalizeExistingPackageToLowercase()
        try {
            if (newTestPath.exists()) {
                if (!recreateExistingTest) {
                    println("Existing test kept. Skipping test generation.")
                    return
                }
                println("Test already exists. Recreating...")
                newTestPath.toFile().deleteRecursively()
                println("Previous test deleted!")
                println()
            }

            newTestPath.toFile().mkdirs()
            println("Created test directory: ${newTestPath.toAbsolutePath()}\n")

            // Create Problem
            val pascalCaseTestName = name.toPascalCase()
            val pascalCaseTestClassName = "${pascalCaseTestName}Test"

            File(newTestPath.toString(), "$pascalCaseTestClassName.kt")
                .writeText(
                    generateTestFileContent(
                        packageName = "me.bossm0n5t3r.leetcode.$filePath",
                        problemClassName = pascalCaseTestName,
                        testClassName = pascalCaseTestClassName,
                        methodParametersAndResultAsString = methodParametersAndResultAsString,
                        exampleTestcases = exampleTestcases,
                    )
                )
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }
}
