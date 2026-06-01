package me.bossm0n5t3r.leetcode.removeElement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RemoveElementTest {
    private val removeElement = RemoveElement.Solution()

    private data class RemoveElementTestData(val nums: IntArray, val `val`: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as RemoveElementTestData

            if (!nums.contentEquals(other.nums)) return false
            if (`val` != other.`val`) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + `val`
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun removeElement() {
        val tests =
            listOf(
                RemoveElementTestData(intArrayOf(3, 2, 2, 3), 3, 2),
                RemoveElementTestData(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2, 5),
            )
        tests.forEach { test ->
            assertEquals(removeElement.removeElement(test.nums, test.`val`), test.result)
        }
    }
}
