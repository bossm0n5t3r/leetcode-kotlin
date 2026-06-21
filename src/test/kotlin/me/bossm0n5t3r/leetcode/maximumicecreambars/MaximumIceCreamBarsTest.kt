package me.bossm0n5t3r.leetcode.maximumicecreambars

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumIceCreamBarsTest {
    private val sut = MaximumIceCreamBars.Solution()

    private data class TestData(val costs: IntArray, val coins: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (coins != other.coins) return false
            if (result != other.result) return false
            if (!costs.contentEquals(other.costs)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = coins
            result1 = 31 * result1 + result
            result1 = 31 * result1 + costs.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(1, 3, 2, 4, 1), 7, 4),
                TestData(intArrayOf(10, 6, 8, 7, 7, 8), 5, 0),
                TestData(intArrayOf(1, 6, 3, 1, 2, 5), 20, 6),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxIceCream(testData.costs, testData.coins))
        }
    }
}
