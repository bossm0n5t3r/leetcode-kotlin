package me.bossm0n5t3r.leetcode.sortColors

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SortColorsTest {
    private val sut = SortColors.Solution()

    private data class TestData(val nums: IntArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[2,0,2,1,1,0]".toIntArray(), "[0,0,1,1,2,2]".toIntArray()),
                TestData("[2,0,1]".toIntArray(), "[0,1,2]".toIntArray()),
            )

        tests.forEach { test ->
            sut.sortColors(test.nums)
            assertTrue(test.nums.contentEquals(test.result))
        }
    }
}
