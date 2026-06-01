package me.bossm0n5t3r.leetcode.totalCostToHireKWorkers

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalCostToHireKWorkersTest {
    private val sut = TotalCostToHireKWorkers.Solution()

    private data class TestData(
        val costs: IntArray,
        val k: Int,
        val candidates: Int,
        val result: Long,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!costs.contentEquals(other.costs)) return false
            if (k != other.k) return false
            if (candidates != other.candidates) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = costs.contentHashCode()
            result1 = 31 * result1 + k
            result1 = 31 * result1 + candidates
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[17,12,10,2,7,2,11,20,8]".toIntArray(), 3, 4, 11),
                TestData("[1,2,4,1]".toIntArray(), 3, 3, 4),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.totalCost(test.costs, test.k, test.candidates))
        }
    }
}
