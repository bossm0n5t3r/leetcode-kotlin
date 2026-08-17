package me.bossm0n5t3r.leetcode.stonegamev

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StoneGameVTest {
    private val sut = StoneGameV.Solution()

    private data class TestData(val stoneValue: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!stoneValue.contentEquals(other.stoneValue)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + stoneValue.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(6, 2, 3, 4, 5, 5), 18),
                TestData(intArrayOf(7, 7, 7, 7, 7, 7, 7), 28),
                TestData(intArrayOf(4), 0),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.stoneGameV(testData.stoneValue))
        }
    }
}
