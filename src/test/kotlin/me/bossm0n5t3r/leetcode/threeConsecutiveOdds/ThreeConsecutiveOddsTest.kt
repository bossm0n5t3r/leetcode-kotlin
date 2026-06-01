package me.bossm0n5t3r.leetcode.threeConsecutiveOdds

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ThreeConsecutiveOddsTest {
    private val sut = ThreeConsecutiveOdds.Solution()

    private data class TestData(val arr: IntArray, val result: Boolean) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!arr.contentEquals(other.arr)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = arr.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[2,6,4,1]".toIntArray(), false),
                TestData("[1,2,34,3,4,5,7,23,12]".toIntArray(), true),
            )

        tests.forEach { test -> assertEquals(test.result, sut.threeConsecutiveOdds(test.arr)) }
    }
}
