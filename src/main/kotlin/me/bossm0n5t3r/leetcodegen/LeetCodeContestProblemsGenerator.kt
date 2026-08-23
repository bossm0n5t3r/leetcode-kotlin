package me.bossm0n5t3r.leetcodegen

import java.io.File
import kotlin.io.path.exists
import kotlinx.coroutines.runBlocking
import me.bossm0n5t3r.leetcodegen.LeetCodeHelper.toPascalCase

object LeetCodeContestProblemsGenerator {
    fun run(contestSlug: String) {
        readProblemTitleSlugs(contestSlug).forEach { titleSlug ->
            with(readProblem(titleSlug)) { this.create() }
        }
    }

    private fun LeetCodeProblem.create() {
        println()
        println("Problem: $name")
        println("URL: $url")
        println()
        createFiles()
        createTest()
        println("Done!")
    }

    private fun readProblemTitleSlugs(contestSlug: String): List<String> = runBlocking {
        LeetCodeClient.getLeetCodeContestProblemTitleSlugsByContestSlug(contestSlug)
    }

    private fun readProblem(titleSlug: String): LeetCodeProblem = runBlocking {
        LeetCodeClient.getLeetCodeProblemByTitleSlug(titleSlug)
    }

    private fun LeetCodeProblem.createFiles() {
        val newProblemPath = problemPath.resolve(filePath)
        try {
            if (newProblemPath.exists()) {
                println("Problem already exists!")
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

    private fun LeetCodeProblem.createTest() {
        val newTestPath = testPath.resolve(filePath)
        try {
            if (newTestPath.exists()) {
                println("Test already exists!")
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
