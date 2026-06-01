package me.bossm0n5t3r.leetcode.specialArrayWithXElementsGreaterThanOrEqualX

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SpecialArrayWithXElementsGreaterThanOrEqualXTest {
    private val sut = SpecialArrayWithXElementsGreaterThanOrEqualX.Solution()

    private data class TestData(val nums: IntArray, val result: Int) {
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
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[3,5]".toIntArray(), 2),
                TestData("[0,0]".toIntArray(), -1),
                TestData("[0,4,3,0,4]".toIntArray(), 3),
            )

        tests.forEach { test -> assertEquals(test.result, sut.specialArray(test.nums)) }
    }
}
