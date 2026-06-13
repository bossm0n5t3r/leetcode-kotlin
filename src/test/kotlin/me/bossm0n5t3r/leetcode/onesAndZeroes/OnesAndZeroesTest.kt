package me.bossm0n5t3r.leetcode.onesAndZeroes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class OnesAndZeroesTest {
    private val onesAndZeroes = OnesAndZeroes.Solution()

    private data class OnesAndZeroesTestData(
        val strs: Array<String>,
        val m: Int,
        val n: Int,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as OnesAndZeroesTestData

            if (!strs.contentEquals(other.strs)) return false
            if (m != other.m) return false
            if (n != other.n) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = strs.contentHashCode()
            result1 = 31 * result1 + m
            result1 = 31 * result1 + n
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun findMaxForm() {
        val tests =
            listOf(
                OnesAndZeroesTestData(arrayOf("10", "0001", "111001", "1", "0"), 5, 3, 4),
                OnesAndZeroesTestData(arrayOf("10", "0", "1"), 1, 1, 2),
            )
        tests.forEach { test ->
            onesAndZeroes.findMaxForm(test.strs, test.m, test.n).also {
                assertEquals(test.result, it)
            }
        }
    }
}
