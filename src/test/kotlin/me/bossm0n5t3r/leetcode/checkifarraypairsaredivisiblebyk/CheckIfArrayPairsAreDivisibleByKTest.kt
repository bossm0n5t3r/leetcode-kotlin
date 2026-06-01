package me.bossm0n5t3r.leetcode.checkifarraypairsaredivisiblebyk

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheckIfArrayPairsAreDivisibleByKTest {
    private val sut = CheckIfArrayPairsAreDivisibleByK.Solution()

    private data class TestData(val arr: IntArray, val k: Int, val result: Boolean) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!arr.contentEquals(other.arr)) return false
            if (k != other.k) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = arr.contentHashCode()
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                //                TestData(intArrayOf(1, 2, 3, 4, 5, 10, 6, 7, 8, 9), 5, true),
                //                TestData(intArrayOf(1, 2, 3, 4, 5, 6), 7, true),
                //                TestData(intArrayOf(1, 2, 3, 4, 5, 6), 10, false),
                //                TestData(intArrayOf(3, 8, 7, 2), 10, true),
                //                TestData(intArrayOf(75, 5, -5, 75, -2, -3, 88, 10, 10, 87), 85,
                // true),
                TestData(intArrayOf(-1, -1, -1, -1, 2, 2, -2, -2), 3, false)
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.canArrange(testData.arr, testData.k))
        }
    }
}
