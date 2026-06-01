package me.bossm0n5t3r.leetcode.maximumNumberOfIntegersToChooseFromARangeI

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfIntegersToChooseFromARangeITest {
    private val sut = MaximumNumberOfIntegersToChooseFromARangeI.Solution()

    private data class TestData(
        val banned: IntArray,
        val n: Int,
        val maxSum: Int,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!banned.contentEquals(other.banned)) return false
            if (n != other.n) return false
            if (maxSum != other.maxSum) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = banned.contentHashCode()
            result1 = 31 * result1 + n
            result1 = 31 * result1 + maxSum
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[1,6,5]".toIntArray(), 5, 6, 2),
                TestData("[1,2,3,4,5,6,7]".toIntArray(), 8, 1, 0),
                TestData("[11]".toIntArray(), 7, 50, 7),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.maxCount(test.banned, test.n, test.maxSum))
        }
    }
}
