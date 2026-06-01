package me.bossm0n5t3r.leetcode.kthDistinctStringInAnArray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthDistinctStringInAnArrayTest {
    private val sut = KthDistinctStringInAnArray.Solution()

    private data class TestData(val arr: Array<String>, val k: Int, val result: String) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!arr.contentEquals(other.arr)) return false
            if (k != other.k) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = arr.contentHashCode()
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(arrayOf("d", "b", "c", "b", "c", "a"), 2, "a"),
                TestData(arrayOf("aaa", "aa", "a"), 1, "aaa"),
                TestData(arrayOf("a", "b", "a"), 3, ""),
            )

        tests.forEach { test -> assertEquals(test.result, sut.kthDistinct(test.arr, test.k)) }
    }
}
