package me.bossm0n5t3r.leetcode.divideastringintogroupsofsizek

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DivideAStringIntoGroupsOfSizeKTest {
    private val sut = DivideAStringIntoGroupsOfSizeK.Solution()

    private data class TestData(
        val s: String,
        val k: Int,
        val fill: Char,
        val result: Array<String>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (k != other.k) return false
            if (fill != other.fill) return false
            if (s != other.s) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = k
            result1 = 31 * result1 + fill.hashCode()
            result1 = 31 * result1 + s.hashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("abcdefghi", 3, 'x', arrayOf("abc", "def", "ghi")),
                TestData("abcdefghij", 3, 'x', arrayOf("abc", "def", "ghi", "jxx")),
            )

        for (testData in testDataList) {
            assertTrue {
                testData.result.contentDeepEquals(
                    sut.divideString(testData.s, testData.k, testData.fill)
                )
            }
        }
    }
}
