package me.bossm0n5t3r.leetcode.findTheDuplicateNumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheDuplicateNumberTest {
    private val findTheDuplicateNumber = FindTheDuplicateNumber.Solution()

    data class FindTheDuplicateNumberTestData(val nums: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as FindTheDuplicateNumberTestData

            if (!nums.contentEquals(other.nums)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun findDuplicate() {
        val tests =
            listOf(
                FindTheDuplicateNumberTestData(intArrayOf(1, 3, 4, 2, 2), 2),
                FindTheDuplicateNumberTestData(intArrayOf(3, 1, 3, 4, 2), 3),
            )
        tests.forEach { test ->
            assertEquals(findTheDuplicateNumber.findDuplicateUsingSet(test.nums), test.result)
            assertEquals(findTheDuplicateNumber.findDuplicateUsingArray(test.nums), test.result)
            assertEquals(findTheDuplicateNumber.findDuplicateUsingO1Space(test.nums), test.result)
        }
    }
}
