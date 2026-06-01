package me.bossm0n5t3r.leetcode.closestprimenumbersinrange

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ClosestPrimeNumbersInRangeTest {
    private val sut = ClosestPrimeNumbersInRange.Solution()

    private data class TestData(val left: Int, val right: Int, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (left != other.left) return false
            if (right != other.right) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = left
            result1 = 31 * result1 + right
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(TestData(10, 19, "[11,13]".toIntArray()), TestData(4, 6, "[-1,-1]".toIntArray()))

        for (testData in testDataList) {
            val expected = testData.result
            val actual = sut.closestPrimes(testData.left, testData.right)
            assertTrue(
                expected.contentEquals(actual),
                "expected: ${expected.toList()}, actual: ${actual.toList()}",
            )
        }
    }
}
