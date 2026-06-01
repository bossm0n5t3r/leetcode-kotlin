package me.bossm0n5t3r.leetcode.trionicarrayii

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TrionicArrayIITest {
    private val sut = TrionicArrayII.Solution()

    private data class TestData(val nums: IntArray, val result: Long) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!nums.contentEquals(other.nums)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result.hashCode()
            result1 = 31 * result1 + nums.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[0,-2,-1,-3,0,2,-1]".toIntArray(), -4),
                TestData("[1,4,2,7]".toIntArray(), 14),
                TestData("[-533,224,-324,251,231,479]".toIntArray(), 637),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxSumTrionic(testData.nums))
        }
    }
}
