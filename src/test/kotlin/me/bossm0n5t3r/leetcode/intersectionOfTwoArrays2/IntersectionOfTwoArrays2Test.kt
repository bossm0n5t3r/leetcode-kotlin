package me.bossm0n5t3r.leetcode.intersectionOfTwoArrays2

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class IntersectionOfTwoArrays2Test {
    private val intersectionOfTwoArrays2 = IntersectionOfTwoArrays2.Solution()

    data class IntersectionOfTwoArrays2TestData(
        val num1: IntArray,
        val num2: IntArray,
        val result: IntArray,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as IntersectionOfTwoArrays2TestData

            if (!num1.contentEquals(other.num1)) return false
            if (!num2.contentEquals(other.num2)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = num1.contentHashCode()
            result1 = 31 * result1 + num2.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun intersect() {
        val tests =
            listOf(
                IntersectionOfTwoArrays2TestData(
                    intArrayOf(1, 2, 2, 1),
                    intArrayOf(2, 2),
                    intArrayOf(2, 2),
                ),
                IntersectionOfTwoArrays2TestData(
                    intArrayOf(4, 9, 5),
                    intArrayOf(9, 4, 9, 8, 4),
                    intArrayOf(9, 4),
                ),
            )
        tests.forEach { test ->
            assertTrue(
                intersectionOfTwoArrays2.intersect(test.num1, test.num2).contentEquals(test.result)
            )
        }
    }
}
