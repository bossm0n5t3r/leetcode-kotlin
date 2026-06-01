package me.bossm0n5t3r.leetcode.longestStringChain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LongestStringChainTest {
    private val longestStringChain = LongestStringChain.Solution()

    private data class LongestStringChainTestData(val words: Array<String>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as LongestStringChainTestData

            if (!words.contentEquals(other.words)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = words.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun longestStrChain() {
        val tests =
            listOf(
                LongestStringChainTestData(arrayOf("a", "b", "ba", "bca", "bda", "bdca"), 4),
                LongestStringChainTestData(arrayOf("xbc", "pcxbcf", "xb", "cxbc", "pcxbc"), 5),
                LongestStringChainTestData(arrayOf("bdca", "bda", "ca", "dca", "a"), 4),
                LongestStringChainTestData(
                    arrayOf(
                        "ksqvsyq",
                        "ks",
                        "kss",
                        "czvh",
                        "zczpzvdhx",
                        "zczpzvh",
                        "zczpzvhx",
                        "zcpzvh",
                        "zczvh",
                        "gr",
                        "grukmj",
                        "ksqvsq",
                        "gruj",
                        "kssq",
                        "ksqsq",
                        "grukkmj",
                        "grukj",
                        "zczpzfvdhx",
                        "gru",
                    ),
                    7,
                ),
            )
        tests.forEach { test ->
            longestStringChain.longestStrChain(test.words).also {
                println(it)
                assertEquals(it, test.result)
            }
        }
    }
}
