package me.bossm0n5t3r.leetcode.oneThreeTwoPattern

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OneThreeTwoPatternTest {
    private val sut = OneThreeTwoPattern.Solution()

    private data class TestData(val nums: IntArray, val result: Boolean) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

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
    fun test() {
        val tests =
            listOf(
                TestData("[1,2,3,4]".toIntArray(), false),
                TestData("[3,1,4,2]".toIntArray(), true),
                TestData("[-1,3,2,0]".toIntArray(), true),
                TestData("[3,5,0,3,4]".toIntArray(), true),
                TestData("[1,0,1,-4,-3]".toIntArray(), false),
                TestData("[-2,1,1]".toIntArray(), false),
                TestData("[1,3,2,4,5,6,7,8,9,10]".toIntArray(), true),
            )

        tests.forEach { test -> assertEquals(test.result, sut.find132pattern(test.nums)) }
    }
}
