package me.bossm0n5t3r.leetcode.twoSum

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TwoSumTest {
    private val solution = TwoSum.Solution()

    data class TwoSumTestData(val nums: IntArray, val target: Int, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TwoSumTestData

            if (!nums.contentEquals(other.nums)) return false
            if (target != other.target) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + target
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun twoSum() {
        val tests =
            listOf(
                TwoSumTestData(intArrayOf(2, 7, 11, 15), 9, intArrayOf(0, 1)),
                TwoSumTestData(intArrayOf(3, 2, 4), 6, intArrayOf(1, 2)),
                TwoSumTestData(intArrayOf(3, 3), 6, intArrayOf(0, 1)),
                TwoSumTestData(intArrayOf(0, 4, 3, 0), 0, intArrayOf(0, 3)),
            )
        tests.forEach { test ->
            assertTrue(solution.twoSumBruteForce(test.nums, test.target).contentEquals(test.result))
            assertTrue(solution.twoSumHashTable(test.nums, test.target).contentEquals(test.result))
        }
    }
}
