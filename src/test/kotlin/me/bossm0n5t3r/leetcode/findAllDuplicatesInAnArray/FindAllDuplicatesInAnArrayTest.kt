package me.bossm0n5t3r.leetcode.findAllDuplicatesInAnArray

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FindAllDuplicatesInAnArrayTest {
    private val sut = FindAllDuplicatesInAnArray.Solution()

    private data class TestData(val nums: IntArray, val result: List<Int>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

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
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1), listOf(2, 3)),
                TestData(intArrayOf(1, 1, 2), listOf(1)),
                TestData(intArrayOf(1), listOf()),
            )

        tests.forEach { test ->
            assertThat(sut.findDuplicates(test.nums)).containsExactlyElementsOf(test.result)
        }
    }
}
