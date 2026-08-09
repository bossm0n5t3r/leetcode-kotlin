package me.bossm0n5t3r.leetcode.stonegameii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StoneGameIITest {
    private val sut = StoneGameII.Solution()

    private data class TestData(val piles: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!piles.contentEquals(other.piles)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + piles.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(2, 7, 9, 4, 4), 10),
                TestData(intArrayOf(1, 2, 3, 4, 5, 100), 104),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.stoneGameII(testData.piles))
        }
    }
}
