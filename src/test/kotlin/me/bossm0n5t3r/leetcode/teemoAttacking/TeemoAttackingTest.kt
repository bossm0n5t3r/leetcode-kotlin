package me.bossm0n5t3r.leetcode.teemoAttacking

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TeemoAttackingTest {
    private val sut = TeemoAttacking.Solution()

    private data class TestData(val timeSeries: IntArray, val duration: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!timeSeries.contentEquals(other.timeSeries)) return false
            if (duration != other.duration) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = timeSeries.contentHashCode()
            result1 = 31 * result1 + duration
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(timeSeries = "[1,4]".toIntArray(), duration = 2, result = 4),
                TestData(timeSeries = "[1,2]".toIntArray(), duration = 2, result = 3),
            )

        tests.forEach { test ->
            assertEquals(sut.findPoisonedDuration(test.timeSeries, test.duration), test.result)
        }
    }
}
