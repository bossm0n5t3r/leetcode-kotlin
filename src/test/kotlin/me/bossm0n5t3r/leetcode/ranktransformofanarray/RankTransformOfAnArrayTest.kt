package me.bossm0n5t3r.leetcode.ranktransformofanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RankTransformOfAnArrayTest {
    private val sut = RankTransformOfAnArray.Solution()

    private data class TestData(val arr: IntArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!arr.contentEquals(other.arr)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = arr.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(40, 10, 20, 30), intArrayOf(4, 1, 2, 3)),
                TestData(intArrayOf(100, 100, 100), intArrayOf(1, 1, 1)),
                TestData(
                    intArrayOf(37, 12, 28, 9, 100, 56, 80, 5, 12),
                    intArrayOf(5, 3, 4, 2, 8, 6, 7, 1, 3),
                ),
            )

        for (testData in testDataList) {
            assertEquals(testData.result.toList(), sut.arrayRankTransform(testData.arr).toList())
        }
    }
}
