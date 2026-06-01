package me.bossm0n5t3r.leetcode.textJustification

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TextJustificationTest {
    private val sut = TextJustification.Solution()

    private data class TestData(
        val words: Array<String>,
        val maxWidth: Int,
        val result: List<String>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!words.contentEquals(other.words)) return false
            if (maxWidth != other.maxWidth) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = words.contentHashCode()
            result1 = 31 * result1 + maxWidth
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    arrayOf("This", "is", "an", "example", "of", "text", "justification."),
                    16,
                    listOf("This    is    an", "example  of text", "justification.  "),
                ),
                TestData(
                    arrayOf("What", "must", "be", "acknowledgment", "shall", "be"),
                    16,
                    listOf("What   must   be", "acknowledgment  ", "shall be        "),
                ),
                TestData(
                    arrayOf(
                        "Science",
                        "is",
                        "what",
                        "we",
                        "understand",
                        "well",
                        "enough",
                        "to",
                        "explain",
                        "to",
                        "a",
                        "computer.",
                        "Art",
                        "is",
                        "everything",
                        "else",
                        "we",
                        "do",
                    ),
                    20,
                    listOf(
                        "Science  is  what we",
                        "understand      well",
                        "enough to explain to",
                        "a  computer.  Art is",
                        "everything  else  we",
                        "do                  ",
                    ),
                ),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.fullJustify(test.words, test.maxWidth))
        }
    }
}
