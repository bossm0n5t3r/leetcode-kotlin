package me.bossm0n5t3r.leetcode.searchInRotatedSortedArray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SearchInRotatedSortedArrayTest {
    private val sut = SearchInRotatedSortedArray.Solution()

    private data class Example(val nums: IntArray, val target: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Example

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
    fun search() {
        val tests =
            listOf(
                Example(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0, 4),
                Example(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3, -1),
                Example(intArrayOf(1), 0, -1),
            )
        tests.forEach { test -> assertEquals(sut.search(test.nums, test.target), test.result) }
    }
}
