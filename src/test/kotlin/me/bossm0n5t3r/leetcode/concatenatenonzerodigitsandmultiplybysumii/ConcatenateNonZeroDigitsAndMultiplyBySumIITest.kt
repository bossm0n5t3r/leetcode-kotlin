package me.bossm0n5t3r.leetcode.concatenatenonzerodigitsandmultiplybysumii

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConcatenateNonZeroDigitsAndMultiplyBySumIITest {
    private val sut = ConcatenateNonZeroDigitsAndMultiplyBySumII.Solution()

    private data class TestData(val s: String, val queries: Array<IntArray>, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (s != other.s) return false
            if (!queries.contentDeepEquals(other.queries)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = s.hashCode()
            result1 = 31 * result1 + queries.contentDeepHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "10203004",
                    "[[0,7],[1,3],[4,6]]".toArrayOfIntArray(),
                    intArrayOf(12340, 4, 9),
                ),
                TestData("1000", "[[0,3],[1,1]]".toArrayOfIntArray(), intArrayOf(1, 0)),
                TestData("9876543210", "[[0,9]]".toArrayOfIntArray(), intArrayOf(444444137)),
                TestData(
                    "9223538386222334255",
                    "[[0,18]]".toArrayOfIntArray(),
                    intArrayOf(632582266),
                ),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result.toList(),
                sut.sumAndMultiply(testData.s, testData.queries).toList(),
            )
        }
    }
}
