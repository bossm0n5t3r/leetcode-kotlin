package me.bossm0n5t3r.leetcode.applyoperationstoanarray

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ApplyOperationsToAnArrayTest {
    private val sut = ApplyOperationsToAnArray.Solution()

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
                TestData("[1,2,2,1,1,0]".toIntArray(), "[1,4,2,0,0,0]".toIntArray()),
                TestData("[0,1]".toIntArray(), "[1,0]".toIntArray()),
            )

        for (testData in testDataList) {
            assertTrue { testData.result.contentEquals(sut.applyOperations(testData.nums)) }
        }
    }
}
