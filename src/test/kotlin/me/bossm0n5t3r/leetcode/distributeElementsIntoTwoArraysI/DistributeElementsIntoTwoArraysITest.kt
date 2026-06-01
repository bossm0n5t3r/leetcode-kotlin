package me.bossm0n5t3r.leetcode.distributeElementsIntoTwoArraysI

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DistributeElementsIntoTwoArraysITest {
    private val sut = DistributeElementsIntoTwoArraysI.Solution()

    private data class TestData(val nums: IntArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(2, 1, 3), intArrayOf(2, 3, 1)),
                TestData(intArrayOf(5, 4, 3, 8), intArrayOf(5, 3, 4, 8)),
            )

        tests.forEach { test -> assertThat(sut.resultArray(test.nums)).isEqualTo(test.result) }
    }
}
