package me.bossm0n5t3r.leetcodegen

internal fun generateTestFileContent(
    packageName: String,
    problemClassName: String,
    testClassName: String,
    methodParametersAndResultAsString: String,
    exampleTestcases: String,
): String = buildString {
    appendLine("package $packageName")
    appendLine()
    appendLine("import org.junit.jupiter.api.Test")
    appendLine("import org.junit.jupiter.api.Assertions.assertEquals")
    appendLine()
    appendLine("class $testClassName {")
    appendLine("    private val sut = $problemClassName.Solution()")
    appendLine()
    appendLine("    private class TestData($methodParametersAndResultAsString)")
    appendLine()
    appendLine("    @Test")
    appendLine("    fun test() {")
    appendLine("        // Example Testcases")
    appendLine("        // $exampleTestcases")
    appendLine("        val testDataList = listOf(")
    appendLine("            TestData(),")
    appendLine("        )")
    appendLine()
    appendLine("        for (testData in testDataList) {")
    appendLine("            assertEquals(")
    appendLine("                testData.result,")
    appendLine("                sut")
    appendLine("            )")
    appendLine("        }")
    appendLine("    }")
    appendLine("}")
}
