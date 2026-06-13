package me.bossm0n5t3r.leetcode.kidsWithTheGreatestNumberOfCandies

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KidsWithTheGreatestNumberOfCandiesTest {
    private val sut = KidsWithTheGreatestNumberOfCandies.Solution()

    private data class TestData(
        val candies: IntArray,
        val extraCandies: Int,
        val result: List<Boolean>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!candies.contentEquals(other.candies)) return false
            if (extraCandies != other.extraCandies) return false
            return result == other.result
        }

        override fun hashCode(): Int {
            var result1 = candies.contentHashCode()
            result1 = 31 * result1 + extraCandies
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(2, 3, 5, 1, 3), 3, listOf(true, true, true, false, true)),
                TestData(intArrayOf(4, 2, 1, 1, 2), 1, listOf(true, false, false, false, false)),
                TestData(intArrayOf(12, 1, 12), 10, listOf(true, false, true)),
            )
        tests.forEach { test ->
            assertEquals(test.result, sut.kidsWithCandies(test.candies, test.extraCandies))
        }
    }
}
