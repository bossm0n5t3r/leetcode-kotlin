import LeetCodeHelper.makePrettyUrl
import LeetCodeHelper.toLowerCase
import LeetCodeHelper.toPascalCase
import java.io.File
import java.nio.file.Paths
import kotlin.io.path.exists

object ManualLeetCodeProblemGenerator {
    private lateinit var name: String
    private lateinit var url: String
    private val sampleCode = mutableListOf<String>()
    private lateinit var methodParametersAndResultAsString: String

    fun run() {
        readProblem()
        require(this::name.isInitialized)
        require(this::url.isInitialized)
        require(this::methodParametersAndResultAsString.isInitialized)
        val filePath = this.name.toLowerCase()
        createFiles(filePath)
        createTest(filePath)
    }

    private fun readProblem() {
        print("Enter problem name: ")
        var tmpName = readlnOrNull()
        while (tmpName.isNullOrBlank()) {
            println("Problem name cannot be blank")
            print("Enter problem name: ")
            tmpName = readlnOrNull()
        }
        name = tmpName

        print("Enter problem url: ")
        var tmpUrl = readlnOrNull()
        while (tmpUrl.isNullOrBlank()) {
            println("Problem url cannot be blank")
            print("Enter problem url: ")
            tmpUrl = readlnOrNull()
        }
        url = tmpUrl.makePrettyUrl()

        println("Enter sample code: ")
        while (true) {
            val line = readln()
            if (line == "}") {
                sampleCode.add(line)
                break
            }
            sampleCode.add(line)
        }

        methodParametersAndResultAsString =
            sampleCode[1]
                .substringAfter('(')
                .substringBefore('{')
                .split(", ", "): ")
                .let {
                    val lastIndex = it.lastIndex
                    it.mapIndexed { index, s ->
                        if (index != lastIndex) {
                            "val ${s.trim()}"
                        } else {
                            "val result: ${s.trim()}"
                        }
                    }
                }
                .joinToString(", ")
    }

    private fun createFiles(filePath: String) {
        val newProblemPath = Paths.get(problemPath.toString(), filePath)
        try {
            if (newProblemPath.exists()) throw Exception("Directory already exists")

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
            val pascalCaseProblemName = this.name.toPascalCase()
            val sampleCodeString =
                this.sampleCode.joinToString("\n") {
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

    private fun createTest(filePath: String) {
        val newTestPath = Paths.get(testPath.toString(), filePath)
        try {
            if (newTestPath.exists()) throw Exception("Directory already exists")

            newTestPath.toFile().mkdirs()
            println("Created test directory: ${newTestPath.toAbsolutePath()}\n")

            // Create Problem
            val pascalCaseTestName = this.name.toPascalCase()
            val pascalCaseTestClassName = "${pascalCaseTestName}Test"

            File(newTestPath.toString(), "$pascalCaseTestClassName.kt")
                .writeText(
                    generateTestFileContent(
                        packageName = "me.bossm0n5t3r.leetcode.$filePath",
                        problemClassName = pascalCaseTestName,
                        testClassName = pascalCaseTestClassName,
                        methodParametersAndResultAsString = methodParametersAndResultAsString,
                    )
                )
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }
}
