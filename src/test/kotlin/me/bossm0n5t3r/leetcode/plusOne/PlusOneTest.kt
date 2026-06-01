package me.bossm0n5t3r.leetcode.plusOne

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PlusOneTest {
    private val plusOne = PlusOne.Solution()

    data class PlusOneTestData(val digits: IntArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as PlusOneTestData

            if (!digits.contentEquals(other.digits)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = digits.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun plusOne() {
        val tests =
            listOf(
                PlusOneTestData(intArrayOf(1, 2, 3), intArrayOf(1, 2, 4)),
                PlusOneTestData(intArrayOf(4, 3, 2, 1), intArrayOf(4, 3, 2, 2)),
                PlusOneTestData(intArrayOf(0), intArrayOf(1)),
                PlusOneTestData(intArrayOf(9, 9), intArrayOf(1, 0, 0)),
                PlusOneTestData(
                    intArrayOf(
                        5,
                        2,
                        2,
                        6,
                        5,
                        7,
                        1,
                        9,
                        0,
                        3,
                        8,
                        6,
                        8,
                        6,
                        5,
                        2,
                        1,
                        8,
                        7,
                        9,
                        8,
                        3,
                        8,
                        4,
                        7,
                        2,
                        5,
                        8,
                        9,
                    ),
                    intArrayOf(
                        5,
                        2,
                        2,
                        6,
                        5,
                        7,
                        1,
                        9,
                        0,
                        3,
                        8,
                        6,
                        8,
                        6,
                        5,
                        2,
                        1,
                        8,
                        7,
                        9,
                        8,
                        3,
                        8,
                        4,
                        7,
                        2,
                        5,
                        9,
                        0,
                    ),
                ),
            )
        tests.forEach { test ->
            assertTrue(plusOne.plusOne(test.digits).contentEquals(test.result))
        }
    }
}
