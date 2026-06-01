package me.bossm0n5t3r.leetcode.extraCharactersInAString

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ExtraCharactersInAStringTest {
    private val sut = ExtraCharactersInAString.Solution()

    private data class TestData(val s: String, val dictionary: Array<String>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (s != other.s) return false
            if (!dictionary.contentEquals(other.dictionary)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = s.hashCode()
            result1 = 31 * result1 + dictionary.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("leetscode", arrayOf("leet", "code", "leetcode"), 1),
                TestData("sayhelloworld", arrayOf("hello", "world"), 3),
                TestData(
                    "dwmodizxvvbosxxw",
                    arrayOf(
                        "ox",
                        "lb",
                        "diz",
                        "gu",
                        "v",
                        "ksv",
                        "o",
                        "nuq",
                        "r",
                        "txhe",
                        "e",
                        "wmo",
                        "cehy",
                        "tskz",
                        "ds",
                        "kzbu",
                    ),
                    7,
                ),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.minExtraChar(test.s, test.dictionary))
        }
    }
}
