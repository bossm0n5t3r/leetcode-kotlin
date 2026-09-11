package me.bossm0n5t3r.leetcode.unique3digitevennumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Unique3DigitEvenNumbersTest {
    private val sut = Unique3DigitEvenNumbers.Solution()

    private data class TestData(val digits: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!digits.contentEquals(other.digits)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + digits.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(1, 2, 3, 4), 12),
                TestData(intArrayOf(0, 2, 2), 2),
                TestData(intArrayOf(6, 6, 6), 1),
                TestData(intArrayOf(1, 3, 5), 0),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.totalNumbers(testData.digits))
        }
    }
}
