package me.bossm0n5t3r.leetcode.relativeRanks

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RelativeRanksTest {
    private val sut = RelativeRanks.Solution()

    private data class TestData(val score: IntArray, val result: Array<String>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!score.contentEquals(other.score)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = score.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    intArrayOf(5, 4, 3, 2, 1),
                    arrayOf("Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"),
                ),
                TestData(
                    intArrayOf(10, 3, 8, 9, 4),
                    arrayOf("Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"),
                ),
            )

        tests.forEach { test ->
            assertTrue { test.result.contentDeepEquals(sut.findRelativeRanks(test.score)) }
        }
    }
}
