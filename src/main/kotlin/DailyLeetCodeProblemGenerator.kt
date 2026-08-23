import LeetCodeHelper.normalizeExistingPackageToLowercase
import LeetCodeHelper.toLowerCase
import LeetCodeHelper.toPascalCase
import java.io.File
import java.nio.file.Paths
import kotlin.io.path.exists
import kotlinx.coroutines.runBlocking

object DailyLeetCodeProblemGenerator {

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
