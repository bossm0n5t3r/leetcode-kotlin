package me.bossm0n5t3r.leetcode.numberofuniquexortripletsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfUniqueXORTripletsIITest {
    private val sut = NumberOfUniqueXORTripletsII.Solution()

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
            listOf(TestData(intArrayOf(1, 3), 2), TestData(intArrayOf(6, 7, 8, 9), 4))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.uniqueXorTriplets(testData.nums))
        }
    }
}
