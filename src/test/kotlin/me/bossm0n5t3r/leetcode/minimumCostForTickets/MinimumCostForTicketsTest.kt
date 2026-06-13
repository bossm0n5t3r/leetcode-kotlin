package me.bossm0n5t3r.leetcode.minimumCostForTickets

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MinimumCostForTicketsTest {
    private val minimumCostForTickets = MinimumCostForTickets.Solution()

    private data class MinimumCostForTicketsTestData(
        val days: IntArray,
        val costs: IntArray,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as MinimumCostForTicketsTestData

            if (!days.contentEquals(other.days)) return false
            if (!costs.contentEquals(other.costs)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = days.contentHashCode()
            result1 = 31 * result1 + costs.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun minCostTickets() {
        val tests =
            listOf(
                MinimumCostForTicketsTestData(
                    intArrayOf(1, 4, 6, 7, 8, 20),
                    intArrayOf(2, 7, 15),
                    11,
                ),
                MinimumCostForTicketsTestData(
                    intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31),
                    intArrayOf(2, 7, 15),
                    17,
                ),
            )
        tests.forEach { test ->
            minimumCostForTickets.minCostTicketsUsingQueue(test.days, test.costs).also {
                assertEquals(test.result, it)
            }

            minimumCostForTickets.minCostTicketsUsingDP(test.days, test.costs).also {
                assertEquals(test.result, it)
            }
        }
    }
}
