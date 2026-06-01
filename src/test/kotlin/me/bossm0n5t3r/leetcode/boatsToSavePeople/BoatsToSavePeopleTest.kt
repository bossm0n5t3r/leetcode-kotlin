package me.bossm0n5t3r.leetcode.boatsToSavePeople

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BoatsToSavePeopleTest {
    private val sut = BoatsToSavePeople.Solution()

    private data class TestData(val people: IntArray, val limit: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!people.contentEquals(other.people)) return false
            if (limit != other.limit) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = people.contentHashCode()
            result1 = 31 * result1 + limit
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(1, 2), 3, 1),
                TestData(intArrayOf(3, 2, 2, 1), 3, 3),
                TestData(intArrayOf(3, 5, 3, 4), 5, 4),
                TestData(intArrayOf(5, 1, 4, 2), 6, 2),
                TestData(intArrayOf(21, 40, 16, 24, 30), 50, 3),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.numRescueBoats(test.people, test.limit))
        }
    }
}
