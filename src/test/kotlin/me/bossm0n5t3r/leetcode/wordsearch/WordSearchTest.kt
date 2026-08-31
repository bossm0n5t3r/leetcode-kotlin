package me.bossm0n5t3r.leetcode.wordsearch

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class WordSearchTest {
    private val wordSearch = WordSearch.Solution()

    private data class WordSearchTest(
        val board: Array<CharArray>,
        val word: String,
        val result: Boolean,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as WordSearchTest

            if (!board.contentDeepEquals(other.board)) return false
            if (word != other.word) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = board.contentDeepHashCode()
            result1 = 31 * result1 + word.hashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun exist() {
        val tests =
            listOf(
                WordSearchTest(
                    arrayOf(
                        charArrayOf('A', 'B', 'C', 'E'),
                        charArrayOf('S', 'F', 'C', 'S'),
                        charArrayOf('A', 'D', 'E', 'E'),
                    ),
                    "ABCCED",
                    true,
                ),
                WordSearchTest(
                    arrayOf(
                        charArrayOf('A', 'B', 'C', 'E'),
                        charArrayOf('S', 'F', 'C', 'S'),
                        charArrayOf('A', 'D', 'E', 'E'),
                    ),
                    "SEE",
                    true,
                ),
                WordSearchTest(
                    arrayOf(
                        charArrayOf('A', 'B', 'C', 'E'),
                        charArrayOf('S', 'F', 'C', 'S'),
                        charArrayOf('A', 'D', 'E', 'E'),
                    ),
                    "ABCB",
                    false,
                ),
                WordSearchTest(
                    arrayOf(
                        charArrayOf('A', 'B', 'C', 'E'),
                        charArrayOf('S', 'F', 'E', 'S'),
                        charArrayOf('A', 'D', 'E', 'E'),
                    ),
                    "ABCESEEEFS",
                    true,
                ),
                WordSearchTest(
                    arrayOf(
                        charArrayOf('C', 'A', 'A'),
                        charArrayOf('A', 'A', 'A'),
                        charArrayOf('B', 'C', 'D'),
                    ),
                    "AAB",
                    true,
                ),
                WordSearchTest(arrayOf(charArrayOf('a'), charArrayOf('b')), "aba", false),
                WordSearchTest(arrayOf(charArrayOf('a'), charArrayOf('a')), "aa", true),
                WordSearchTest(
                    arrayOf(
                        charArrayOf('A', 'A', 'A', 'A', 'A', 'A'),
                        charArrayOf('A', 'A', 'A', 'A', 'A', 'A'),
                        charArrayOf('A', 'A', 'A', 'A', 'A', 'A'),
                        charArrayOf('A', 'A', 'A', 'A', 'A', 'A'),
                        charArrayOf('A', 'A', 'A', 'A', 'A', 'A'),
                        charArrayOf('A', 'A', 'A', 'A', 'A', 'A'),
                    ),
                    "AAAAAAAAAAAABAA",
                    false,
                ),
            )
        tests.forEach { test -> assertEquals(test.result, wordSearch.exist(test.board, test.word)) }
    }
}
