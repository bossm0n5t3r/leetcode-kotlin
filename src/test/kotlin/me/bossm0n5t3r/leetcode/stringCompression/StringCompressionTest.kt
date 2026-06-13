package me.bossm0n5t3r.leetcode.stringCompression

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringCompressionTest {
    private val sut = StringCompression.Solution()

    private data class TestData(
        val chars: CharArray,
        val modifiedChars: CharArray,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!chars.contentEquals(other.chars)) return false
            return result == other.result
        }

        override fun hashCode(): Int {
            var result1 = chars.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("aabbccc".toCharArray(), "a2b2c3".toCharArray(), 6),
                TestData("a".toCharArray(), "a".toCharArray(), 1),
                TestData("abbbbbbbbbbbb".toCharArray(), "ab12".toCharArray(), 4),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.compress(test.chars))
            assertThat(test.chars.take(test.modifiedChars.size).toCharArray())
                .containsExactly(*test.modifiedChars)
        }
    }
}
