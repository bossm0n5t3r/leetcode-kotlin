package me.bossm0n5t3r.leetcode.timeNeededToBuyTickets

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TimeNeededToBuyTicketsTest {
    private val sut = TimeNeededToBuyTickets.Solution()

    private data class TestData(val tickets: IntArray, val k: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!tickets.contentEquals(other.tickets)) return false
            if (k != other.k) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = tickets.contentHashCode()
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(TestData(intArrayOf(2, 3, 2), 2, 6), TestData(intArrayOf(5, 1, 1, 1), 0, 8))

        tests.forEach { test ->
            assertEquals(test.result, sut.timeRequiredToBuy(test.tickets, test.k))
        }
    }
}
