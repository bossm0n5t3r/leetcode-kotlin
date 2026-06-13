package me.bossm0n5t3r.leetcode.containsDuplicate

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ContainsDuplicateTest {
    private val containsDuplicate = ContainsDuplicate.Solution()

    data class ContainsDuplicateTestData(val nums: IntArray, val result: Boolean) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as ContainsDuplicateTestData

            if (!nums.contentEquals(other.nums)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun containsDuplicate() {
        val tests =
            listOf(
                ContainsDuplicateTestData(intArrayOf(1, 2, 3, 1), true),
                ContainsDuplicateTestData(intArrayOf(1, 2, 3, 4), false),
                ContainsDuplicateTestData(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2), true),
            )
        tests.forEach { test ->
            assertEquals(test.result, containsDuplicate.containsDuplicate(test.nums))
        }
    }
}
