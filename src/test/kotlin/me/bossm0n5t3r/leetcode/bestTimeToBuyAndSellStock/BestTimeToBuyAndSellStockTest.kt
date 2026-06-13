package me.bossm0n5t3r.leetcode.bestTimeToBuyAndSellStock

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStockTest {
    private val bestTimeToBuyAndSellStock = BestTimeToBuyAndSellStock.Solution()

    data class BestTimeToBuyAndSellStockTestData(val prices: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as BestTimeToBuyAndSellStockTestData

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
                BestTimeToBuyAndSellStockTestData(intArrayOf(7, 1, 5, 3, 6, 4), 5),
                BestTimeToBuyAndSellStockTestData(intArrayOf(7, 6, 4, 3, 1), 0),
            )
        tests.forEach { test ->
            assertEquals(test.result, bestTimeToBuyAndSellStock.maxProfit(test.prices))
        }
    }
}
