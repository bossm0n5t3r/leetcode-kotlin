package me.bossm0n5t3r.leetcode.findPolygonWithTheLargestPerimeter

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindPolygonWithTheLargestPerimeterTest {
    private val sut = FindPolygonWithTheLargestPerimeter.Solution()

    private data class TestData(val nums: IntArray, val result: Long) {
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
                TestData("[5,5,5]".toIntArray(), 15),
                TestData("[1,12,1,2,5,50,3]".toIntArray(), 12),
                TestData("[5,5,50]".toIntArray(), -1),
            )

        tests.forEach { test -> assertEquals(test.result, sut.largestPerimeter(test.nums)) }
    }
}
