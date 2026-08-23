import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LeetCodeTestFileGeneratorTest {
    @Test
    fun `generated test template uses TestData placeholder and includes example testcases comment`() {
        val content =
            generateTestFileContent(
                packageName = "me.bossm0n5t3r.leetcode.twosum",
                problemClassName = "TwoSum",
                testClassName = "TwoSumTest",
                methodParametersAndResultAsString =
                    "val nums: IntArray, val target: Int, val result: IntArray",
                exampleTestcases = "2,7,11,15 / 9",
            )

        assertEquals(
            """
            package me.bossm0n5t3r.leetcode.twosum

            import org.junit.jupiter.api.Test
            import org.junit.jupiter.api.Assertions.assertEquals

            class TwoSumTest {
                private val sut = TwoSum.Solution()

                private data class TestData(val nums: IntArray, val target: Int, val result: IntArray)

                @Test
                fun test() {
                    // Example Testcases
                    // 2,7,11,15 / 9
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
                .trimIndent(),
            content,
        )
        assertTrue(
            content.contains("TestData(),"),
            "generated test should keep the fill-in TestData() placeholder",
        )
    }
}
