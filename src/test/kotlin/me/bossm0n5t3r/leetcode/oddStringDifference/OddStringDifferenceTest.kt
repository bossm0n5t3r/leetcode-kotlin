package me.bossm0n5t3r.leetcode.oddStringDifference

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfString
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OddStringDifferenceTest {
    private val sut = OddStringDifference.Solution()

    private data class TestData(val words: Array<String>, val result: String) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!words.contentEquals(other.words)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = words.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[\"adc\",\"wzy\",\"abc\"]".toArrayOfString(), "abc"),
                TestData("[\"aaa\",\"bob\",\"ccc\",\"ddd\"]".toArrayOfString(), "bob"),
            )

        tests.forEach { test -> assertEquals(test.result, sut.oddString(test.words)) }
    }
}
