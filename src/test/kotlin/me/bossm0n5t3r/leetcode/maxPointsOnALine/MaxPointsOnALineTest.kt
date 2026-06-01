package me.bossm0n5t3r.leetcode.maxPointsOnALine

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxPointsOnALineTest {
    private val sut = MaxPointsOnALine.Solution()

    private data class TestData(val points: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!points.contentDeepEquals(other.points)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = points.contentDeepHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    points = arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 3)),
                    result = 3,
                ),
                TestData(
                    points =
                        arrayOf(
                            intArrayOf(1, 1),
                            intArrayOf(3, 2),
                            intArrayOf(5, 3),
                            intArrayOf(4, 1),
                            intArrayOf(2, 3),
                            intArrayOf(1, 4),
                        ),
                    result = 4,
                ),
            )

        tests.forEach { test -> assertEquals(test.result, sut.maxPoints(test.points)) }
    }
}
