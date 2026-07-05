import java.nio.file.Path
import java.nio.file.Paths

data class LeetCodeProblem(
    val name: String,
    val url: String,
    val sampleCodes: List<String>,
    val methodParametersAndResultAsString: String,
    val exampleTestcases: String,
)

data class Problem(
    val name: String,
    val url: String,
    val sampleCodes: List<String>,
    val methodParametersAndResultAsString: String,
    val exampleTestcases: String,
    val filePath: String,
)

private val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
val problemPath: Path = Paths.get(projectDirAbsolutePath, "src/main/kotlin/me/bossm0n5t3r/leetcode")
val testPath: Path = Paths.get(projectDirAbsolutePath, "src/test/kotlin/me/bossm0n5t3r/leetcode")

internal fun generateTestFileContent(
    packageName: String,
    problemClassName: String,
    testClassName: String,
    methodParametersAndResultAsString: String,
    exampleTestcases: String? = null,
): String {
    val bodyLines = mutableListOf<String>()
    bodyLines += "    @Test"
    bodyLines += "    fun test() {"
    if (exampleTestcases != null) {
        bodyLines += "        // Example Testcases"
        bodyLines += "        // $exampleTestcases"
    }
    bodyLines += "        val testDataList = listOf("
    bodyLines += "            TestData(),"
    bodyLines += "        )"
    bodyLines += ""
    bodyLines += "        for (testData in testDataList) {"
    bodyLines += "            assertEquals("
    bodyLines += "                testData.result,"
    bodyLines += "                sut"
    bodyLines += "            )"
    bodyLines += "        }"
    bodyLines += "    }"
    bodyLines += "}"

    return buildString {
        appendLine("package $packageName")
        appendLine()
        appendLine("import org.junit.jupiter.api.Test")
        appendLine("import org.junit.jupiter.api.Assertions.assertEquals")
        appendLine()
        appendLine("class $testClassName {")
        appendLine("    private val sut = $problemClassName.Solution()")
        appendLine()
        appendLine("    private data class TestData($methodParametersAndResultAsString)")
        appendLine()
        bodyLines.forEach { appendLine(it) }
    }
}
