package me.bossm0n5t3r.leetcode.constructuniformparityarrayi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConstructUniformParityArrayITest {
    private val sut = ConstructUniformParityArrayI.Solution()

    private data class TestData(val nums1: IntArray, val result: Boolean) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!nums1.contentEquals(other.nums1)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result.hashCode()
            result1 = 31 * result1 + nums1.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(TestData(intArrayOf(2, 3), true), TestData(intArrayOf(4, 6), true))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.uniformArray(testData.nums1))
        }
    }
}
