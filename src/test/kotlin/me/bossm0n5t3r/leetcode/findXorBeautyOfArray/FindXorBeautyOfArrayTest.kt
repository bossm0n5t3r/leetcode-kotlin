package me.bossm0n5t3r.leetcode.findXorBeautyOfArray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindXorBeautyOfArrayTest {
    private val sut = FindXorBeautyOfArray.Solution()

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
                TestData(intArrayOf(1, 4), 5),
                TestData(intArrayOf(15, 45, 20, 2, 34, 35, 5, 44, 32, 30), 34),
            )

        tests.forEach { test -> assertEquals(test.result, sut.xorBeauty(test.nums)) }
    }
}
