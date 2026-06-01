package me.bossm0n5t3r.leetcode.heightChecker

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HeightCheckerTest {
    private val sut = HeightChecker.Solution()

    private data class TestData(val heights: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!heights.contentEquals(other.heights)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = heights.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[1,1,4,2,1,3]".toIntArray(), 3),
                TestData("[5,1,2,3,4]".toIntArray(), 5),
                TestData("[1,2,3,4,5]".toIntArray(), 0),
            )

        tests.forEach { test -> assertEquals(test.result, sut.heightChecker(test.heights)) }
    }
}
