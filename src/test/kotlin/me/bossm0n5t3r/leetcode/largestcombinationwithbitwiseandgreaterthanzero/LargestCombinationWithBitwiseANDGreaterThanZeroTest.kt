package me.bossm0n5t3r.leetcode.largestcombinationwithbitwiseandgreaterthanzero

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LargestCombinationWithBitwiseANDGreaterThanZeroTest {
    private val sut = LargestCombinationWithBitwiseANDGreaterThanZero.Solution()

    private data class TestData(val candidates: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!candidates.contentEquals(other.candidates)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = candidates.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[16,17,71,62,12,24,14]".toIntArray(), 4),
                TestData("[8,8]".toIntArray(), 2),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.largestCombination(testData.candidates))
        }
    }
}
