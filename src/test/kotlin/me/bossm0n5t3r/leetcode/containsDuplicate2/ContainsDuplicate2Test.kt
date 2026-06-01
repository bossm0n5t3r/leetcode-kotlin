package me.bossm0n5t3r.leetcode.containsDuplicate2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ContainsDuplicate2Test {
    private val containsDuplicate2 = ContainsDuplicate2.Solution()

    private data class ContainsDuplicate2TestData(
        val nums: IntArray,
        val k: Int,
        val result: Boolean,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as ContainsDuplicate2TestData

            if (!nums.contentEquals(other.nums)) return false
            if (k != other.k) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun containsNearbyDuplicate() {
        val tests =
            listOf(
                ContainsDuplicate2TestData(intArrayOf(1, 2, 3, 1), 3, true),
                ContainsDuplicate2TestData(intArrayOf(1, 0, 1, 1), 1, true),
                ContainsDuplicate2TestData(intArrayOf(1, 2, 3, 1, 2, 3), 2, false),
                ContainsDuplicate2TestData(intArrayOf(1), 0, false),
                ContainsDuplicate2TestData(intArrayOf(1), 1, false),
                ContainsDuplicate2TestData(intArrayOf(0, 1, 2, 3, 2, 5), 3, true),
                ContainsDuplicate2TestData(intArrayOf(1, 2, 2, 3), 3, true),
            )
        tests.forEach { test ->
            containsDuplicate2.containsNearbyDuplicate(test.nums, test.k).also {
                println(it)
                assertEquals(it, test.result)
            }
        }
    }
}
