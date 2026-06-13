package me.bossm0n5t3r.leetcode.removeDuplicatesFromSortedArray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveDuplicatesFromSortedArrayTest {
    private val removeDuplicatesFromSortedArray = RemoveDuplicatesFromSortedArray.Solution()

    data class RemoveDuplicatesFromSortedArrayTestData(val nums: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as RemoveDuplicatesFromSortedArrayTestData

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
    fun removeDuplicates() {
        val tests =
            listOf(
                RemoveDuplicatesFromSortedArrayTestData(intArrayOf(1, 1, 2), 2),
                RemoveDuplicatesFromSortedArrayTestData(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4), 5),
            )
        tests.forEach { test ->
            assertEquals(test.result, removeDuplicatesFromSortedArray.removeDuplicates(test.nums))
        }
    }
}
