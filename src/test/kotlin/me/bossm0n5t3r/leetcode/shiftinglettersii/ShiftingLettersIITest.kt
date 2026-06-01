package me.bossm0n5t3r.leetcode.shiftinglettersii

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShiftingLettersIITest {
    private val sut = ShiftingLettersII.Solution()

    private data class TestData(val s: String, val shifts: Array<IntArray>, val result: String) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (s != other.s) return false
            if (!shifts.contentDeepEquals(other.shifts)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = s.hashCode()
            result1 = 31 * result1 + shifts.contentDeepHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("abc", "[[0,1,0],[1,2,1],[0,2,1]]".toArrayOfIntArray(), "ace"),
                TestData("dztz", "[[0,0,0],[1,1,1]]".toArrayOfIntArray(), "catz"),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.shiftingLetters(testData.s, testData.shifts))
        }
    }
}
