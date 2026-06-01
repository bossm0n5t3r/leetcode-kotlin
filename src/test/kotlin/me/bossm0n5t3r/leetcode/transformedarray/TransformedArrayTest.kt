package me.bossm0n5t3r.leetcode.transformedarray

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TransformedArrayTest {
    private val sut = TransformedArray.Solution()

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
        val testDataList =
            listOf(
                TestData("[3,-2,1,1]".toIntArray(), "[1,1,1,3]".toIntArray()),
                TestData("[-1,4,-1]".toIntArray(), "[-1,-1,4]".toIntArray()),
                TestData("[-10,-10]".toIntArray(), "[-10,-10]".toIntArray()),
            )

        for (testData in testDataList) {
            assertTrue(testData.result.contentEquals(sut.constructTransformedArray(testData.nums)))
        }
    }
}
