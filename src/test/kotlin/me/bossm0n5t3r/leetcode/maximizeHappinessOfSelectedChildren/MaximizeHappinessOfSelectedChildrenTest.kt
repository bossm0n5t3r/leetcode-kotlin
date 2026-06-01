package me.bossm0n5t3r.leetcode.maximizeHappinessOfSelectedChildren

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeHappinessOfSelectedChildrenTest {
    private val sut = MaximizeHappinessOfSelectedChildren.Solution()

    private data class TestData(val happiness: IntArray, val k: Int, val result: Long) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!happiness.contentEquals(other.happiness)) return false
            if (k != other.k) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = happiness.contentHashCode()
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(1, 2, 3), 2, 4),
                TestData(intArrayOf(1, 1, 1, 1), 2, 1),
                TestData(intArrayOf(2, 3, 4, 5), 1, 5),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.maximumHappinessSum(test.happiness, test.k))
        }
    }
}
