package me.bossm0n5t3r.leetcode.subsets

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SubsetsTest {
    private val subsets = Subsets.Solution()

    data class SubsetsTestData(val nums: IntArray, val result: List<List<Int>>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as SubsetsTestData

            if (!nums.contentEquals(other.nums)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun subsets() {
        val tests =
            listOf(
                SubsetsTestData(
                    intArrayOf(1, 2, 3),
                    listOf(
                        listOf(),
                        listOf(1),
                        listOf(2),
                        listOf(3),
                        listOf(1, 2),
                        listOf(1, 3),
                        listOf(2, 3),
                        listOf(1, 2, 3),
                    ),
                ),
                SubsetsTestData(intArrayOf(0), listOf(listOf(), listOf(0))),
            )
        tests.forEach { test ->
            val result = subsets.subsets(test.nums)
            assertEquals(result.size, test.result.size)
            assertTrue(result.containsAll(test.result))
        }
    }
}
