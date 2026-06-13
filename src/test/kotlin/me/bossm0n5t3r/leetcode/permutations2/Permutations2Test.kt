package me.bossm0n5t3r.leetcode.permutations2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class Permutations2Test {
    private val permutations2 = Permutations2.Solution()

    private data class Permutations2TestData(val nums: IntArray, val result: List<List<Int>>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Permutations2TestData

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
    fun permuteUnique() {
        val tests =
            listOf(
                Permutations2TestData(
                    intArrayOf(1, 1, 2),
                    listOf(listOf(1, 1, 2), listOf(1, 2, 1), listOf(2, 1, 1)),
                ),
                Permutations2TestData(
                    intArrayOf(1, 2, 3),
                    listOf(
                        listOf(1, 2, 3),
                        listOf(1, 3, 2),
                        listOf(2, 1, 3),
                        listOf(2, 3, 1),
                        listOf(3, 1, 2),
                        listOf(3, 2, 1),
                    ),
                ),
            )
        tests.forEach { test ->
            val result = permutations2.permuteUnique(test.nums)
            assertTrue(result.containsAll(test.result))
            assertEquals(test.result.size, result.size)
        }
    }
}
