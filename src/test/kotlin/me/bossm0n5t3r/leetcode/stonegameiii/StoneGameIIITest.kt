package me.bossm0n5t3r.leetcode.stonegameiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StoneGameIIITest {
    private val sut = StoneGameIII.Solution()

    private data class TestData(val stoneValue: IntArray, val result: String) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!stoneValue.contentEquals(other.stoneValue)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = stoneValue.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(1, 2, 3, 7), "Bob"),
                TestData(intArrayOf(1, 2, 3, -9), "Alice"),
                TestData(intArrayOf(1, 2, 3, 6), "Tie"),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.stoneGameIII(testData.stoneValue))
        }
    }
}
