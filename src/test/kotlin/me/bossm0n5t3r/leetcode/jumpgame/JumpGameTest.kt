package me.bossm0n5t3r.leetcode.jumpgame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JumpGameTest {
    private val sut = JumpGame.Solution()

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
        val testDataList =
            listOf(
                TestData(intArrayOf(2, 3, 1, 1, 4), true),
                TestData(intArrayOf(3, 2, 1, 0, 4), false),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.canJump(testData.nums))
        }
    }
}
