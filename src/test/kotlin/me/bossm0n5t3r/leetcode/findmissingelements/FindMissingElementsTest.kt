package me.bossm0n5t3r.leetcode.findmissingelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMissingElementsTest {
    private val sut = FindMissingElements.Solution()

    private data class TestData(val nums: IntArray, val result: List<Int>) {
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
                TestData(intArrayOf(1, 4, 2, 5), listOf(3)),
                TestData(intArrayOf(7, 8, 6, 9), emptyList()),
                TestData(intArrayOf(5, 1), listOf(2, 3, 4)),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.findMissingElements(testData.nums))
        }
    }
}
