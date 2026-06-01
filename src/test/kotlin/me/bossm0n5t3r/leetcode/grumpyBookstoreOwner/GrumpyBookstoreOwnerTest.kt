package me.bossm0n5t3r.leetcode.grumpyBookstoreOwner

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GrumpyBookstoreOwnerTest {
    private val sut = GrumpyBookstoreOwner.Solution()

    private data class TestData(
        val customers: IntArray,
        val grumpy: IntArray,
        val minutes: Int,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!customers.contentEquals(other.customers)) return false
            if (!grumpy.contentEquals(other.grumpy)) return false
            if (minutes != other.minutes) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = customers.contentHashCode()
            result1 = 31 * result1 + grumpy.contentHashCode()
            result1 = 31 * result1 + minutes
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    intArrayOf(1, 0, 1, 2, 1, 1, 7, 5),
                    intArrayOf(0, 1, 0, 1, 0, 1, 0, 1),
                    3,
                    16,
                ),
                TestData(intArrayOf(1), intArrayOf(0), 1, 1),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.maxSatisfied(test.customers, test.grumpy, test.minutes))
        }
    }
}
