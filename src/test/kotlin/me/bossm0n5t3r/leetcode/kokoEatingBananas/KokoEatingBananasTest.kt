package me.bossm0n5t3r.leetcode.kokoEatingBananas

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KokoEatingBananasTest {
    private val sut = KokoEatingBananas.Solution()

    private data class TestData(val piles: IntArray, val h: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!piles.contentEquals(other.piles)) return false
            if (h != other.h) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = piles.contentHashCode()
            result1 = 31 * result1 + h
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(piles = "[3,6,7,11]".toIntArray(), h = 8, result = 4),
                TestData(piles = "[30,11,23,4,20]".toIntArray(), h = 5, result = 30),
                TestData(piles = "[30,11,23,4,20]".toIntArray(), h = 6, result = 23),
                TestData(piles = "[3,6,7,11]".toIntArray(), h = 18, result = 2),
                TestData(
                    piles = "[805306368,805306368,805306368]".toIntArray(),
                    h = 1000000000,
                    result = 3,
                ),
            )

        tests.forEach { test -> assertEquals(sut.minEatingSpeed(test.piles, test.h), test.result) }
    }
}
