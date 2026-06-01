import LeetCodeHelper.toLowerCase
import LeetCodeHelper.toPascalCase
import java.io.File
import java.nio.file.Paths
import kotlin.io.path.exists
import kotlinx.coroutines.runBlocking

object DailyLeetCodeProblemGenerator {
    fun generateProblem(titleSlug: String = "") =
        if (titleSlug.isBlank()) {
            run()
        } else {
            run(titleSlug)
        }

    private fun run() {
        with(readProblem()) {
            println()
            println("Problem: $name")
            println("URL: $url")
            println()
            createFiles(this)
            createTest(this)
            println("Done!")
        }
    }

    private fun run(titleSlug: String) {
        with(readProblem(titleSlug)) {
            println()
            println("Problem: $name")
            println("URL: $url")
            println()
            createFiles(this)
            createTest(this)
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

    private fun createFiles(problem: Problem) {
        val (name, url, sampleCodes, _, _, filePath) = problem
        val newProblemPath = Paths.get(problemPath.toString(), filePath)
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

    private fun createTest(problem: Problem) {
        val (name, _, _, methodParametersAndResultAsString, exampleTestcases, filePath) = problem
        val newTestPath = Paths.get(testPath.toString(), filePath)
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
                    """
                package me.bossm0n5t3r.leetcode.$filePath

                import org.junit.jupiter.api.Test
                import org.junit.jupiter.api.Assertions.assertEquals

                class $pascalCaseTestClassName {
                    private val sut = $pascalCaseTestName.Solution()
                    
                    private data class TestData($methodParametersAndResultAsString)
                    
                    @Test
                    fun test() {
                        // Example Testcases
                        // $exampleTestcases
                        val testDataList = listOf(
                            TestData(),
                        )
                        
                        for (testData in testDataList) {
                            assertEquals(
                                testData.result,
                                sut
                            )
                        }
                    }
                }

                """
                        .trimIndent()
                )
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }
}
