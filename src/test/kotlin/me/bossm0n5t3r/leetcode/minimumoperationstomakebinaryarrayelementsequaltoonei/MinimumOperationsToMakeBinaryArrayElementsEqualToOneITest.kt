package me.bossm0n5t3r.leetcode.minimumoperationstomakebinaryarrayelementsequaltoonei

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeBinaryArrayElementsEqualToOneITest {
    private val sut = MinimumOperationsToMakeBinaryArrayElementsEqualToOneI.Solution()

    private data class TestData(val nums: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!nums.contentEquals(other.nums)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + nums.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[0,1,1,1,0,0]".toIntArray(), 3),
                TestData("[0,1,1,1]".toIntArray(), -1),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minOperations(testData.nums))
        }
    }
}
