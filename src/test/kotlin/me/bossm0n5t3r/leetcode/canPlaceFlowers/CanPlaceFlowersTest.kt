package me.bossm0n5t3r.leetcode.canPlaceFlowers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CanPlaceFlowersTest {
    private val sut = CanPlaceFlowers.Solution()

    private data class TestData(val flowerbed: IntArray, val n: Int, val result: Boolean) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!flowerbed.contentEquals(other.flowerbed)) return false
            if (n != other.n) return false
            return result == other.result
        }

        override fun hashCode(): Int {
            var result1 = flowerbed.contentHashCode()
            result1 = 31 * result1 + n
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(1, 0, 0, 0, 1), 1, true),
                TestData(intArrayOf(1, 0, 0, 0, 1), 2, false),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.canPlaceFlowers(test.flowerbed, test.n))
        }
    }
}
