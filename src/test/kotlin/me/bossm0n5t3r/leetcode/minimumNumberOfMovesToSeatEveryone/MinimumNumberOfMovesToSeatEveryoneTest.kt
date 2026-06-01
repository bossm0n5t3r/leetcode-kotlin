package me.bossm0n5t3r.leetcode.minimumNumberOfMovesToSeatEveryone

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfMovesToSeatEveryoneTest {
    private val sut = MinimumNumberOfMovesToSeatEveryone.Solution()

    private data class TestData(val seats: IntArray, val students: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!seats.contentEquals(other.seats)) return false
            if (!students.contentEquals(other.students)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = seats.contentHashCode()
            result1 = 31 * result1 + students.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[3,1,5]".toIntArray(), "[2,7,4]".toIntArray(), 4),
                TestData("[4,1,5,9]".toIntArray(), "[1,3,2,6]".toIntArray(), 7),
                TestData("[2,2,6,6]".toIntArray(), "[1,3,2,6]".toIntArray(), 4),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.minMovesToSeat(test.seats, test.students))
        }
    }
}
