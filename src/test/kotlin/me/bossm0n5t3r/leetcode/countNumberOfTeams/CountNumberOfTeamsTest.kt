package me.bossm0n5t3r.leetcode.countNumberOfTeams

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumberOfTeamsTest {
    private val sut = CountNumberOfTeams.Solution()

    private data class TestData(val rating: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!rating.contentEquals(other.rating)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = rating.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(2, 5, 3, 4, 1), 3),
                TestData(intArrayOf(2, 1, 3), 0),
                TestData(intArrayOf(1, 2, 3, 4), 4),
            )

        tests.forEach { test -> assertEquals(test.result, sut.numTeams(test.rating)) }
    }
}
