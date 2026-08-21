package me.bossm0n5t3r.leetcode.kthsmallestamountwithsingledenominationcombination

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthSmallestAmountWithSingleDenominationCombinationTest {
    private val sut = KthSmallestAmountWithSingleDenominationCombination.Solution()

    private data class TestData(val coins: IntArray, val k: Int, val result: Long) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (k != other.k) return false
            if (result != other.result) return false
            if (!coins.contentEquals(other.coins)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = k
            result1 = 31 * result1 + result.hashCode()
            result1 = 31 * result1 + coins.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(3, 6, 9), 3, 9),
                TestData(intArrayOf(5, 2), 7, 12),
                TestData(intArrayOf(5), 7, 35),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.findKthSmallest(testData.coins, testData.k))
        }
    }
}
