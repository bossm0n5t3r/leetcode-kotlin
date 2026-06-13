package me.bossm0n5t3r.leetcode.threeSumClosest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ThreeSumClosestTest {
    private val threeSumClosest = ThreeSumClosest.Solution()

    private data class ThreeSumClosestTestData(
        val nums: IntArray,
        val target: Int,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as ThreeSumClosestTestData

            if (!nums.contentEquals(other.nums)) return false
            if (target != other.target) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + target
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun threeSumClosest() {
        val tests =
            listOf(
                ThreeSumClosestTestData(intArrayOf(-1, 2, 1, -4), 1, 2),
                ThreeSumClosestTestData(intArrayOf(0, 0, 0), 1, 0),
            )
        tests.forEach { test ->
            assertEquals(test.result, threeSumClosest.threeSumClosest(test.nums, test.target))
        }
    }
}
