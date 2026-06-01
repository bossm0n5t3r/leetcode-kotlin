package me.bossm0n5t3r.leetcode.permutations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PermutationsTest {
    private val permutations = Permutations.Solution()

    data class PermutationsTestData(val nums: IntArray, val result: List<List<Int>>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as PermutationsTestData

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
    fun permute() {
        val tests =
            listOf(
                PermutationsTestData(
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
                PermutationsTestData(intArrayOf(0, 1), listOf(listOf(0, 1), listOf(1, 0))),
                PermutationsTestData(intArrayOf(1), listOf(listOf(1))),
            )
        tests.forEach { test ->
            val result = permutations.permute(test.nums)
            assertTrue(result.containsAll(test.result))
            assertEquals(result.size, test.result.size)
        }
    }
}
