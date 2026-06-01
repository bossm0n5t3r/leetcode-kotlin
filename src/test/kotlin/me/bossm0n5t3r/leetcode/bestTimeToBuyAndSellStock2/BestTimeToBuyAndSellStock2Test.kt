package me.bossm0n5t3r.leetcode.bestTimeToBuyAndSellStock2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStock2Test {
    private val bestTimeToBuyAndSellStock2 = BestTimeToBuyAndSellStock2.Solution()

    data class BestTimeToBuyAndSellStock2TestData(val prices: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as BestTimeToBuyAndSellStock2TestData

            if (!prices.contentEquals(other.prices)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = prices.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun maxProfit() {
        val tests =
            listOf(
                BestTimeToBuyAndSellStock2TestData(intArrayOf(7, 1, 5, 3, 6, 4), 7),
                BestTimeToBuyAndSellStock2TestData(intArrayOf(1, 2, 3, 4, 5), 4),
                BestTimeToBuyAndSellStock2TestData(intArrayOf(7, 6, 4, 3, 1), 0),
            )
        tests.forEach { test ->
            assertEquals(bestTimeToBuyAndSellStock2.maxProfit(test.prices), test.result)
        }
    }
}
