package me.bossm0n5t3r.leetcode.numberOfStudentsUnableToEatLunch

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfStudentsUnableToEatLunchTest {
    private val sut = NumberOfStudentsUnableToEatLunch.Solution()

    private data class TestData(val students: IntArray, val sandwiches: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!students.contentEquals(other.students)) return false
            if (!sandwiches.contentEquals(other.sandwiches)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = students.contentHashCode()
            result1 = 31 * result1 + sandwiches.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(1, 1, 0, 0), intArrayOf(0, 1, 0, 1), 0),
                TestData(intArrayOf(1, 1, 1, 0, 0, 1), intArrayOf(1, 0, 0, 0, 1, 1), 3),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.countStudents(test.students, test.sandwiches))
        }
    }
}
