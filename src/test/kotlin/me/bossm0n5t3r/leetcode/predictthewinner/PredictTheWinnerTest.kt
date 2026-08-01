package me.bossm0n5t3r.leetcode.predictthewinner

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PredictTheWinnerTest {
    private val sut = PredictTheWinner.Solution()

    private data class TestData(val nums: IntArray, val result: Boolean) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!nums.contentEquals(other.nums)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result.hashCode()
            result1 = 31 * result1 + nums.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(TestData(intArrayOf(1, 5, 2), false), TestData(intArrayOf(1, 5, 233, 7), true))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.predictTheWinner(testData.nums))
        }
    }
}
