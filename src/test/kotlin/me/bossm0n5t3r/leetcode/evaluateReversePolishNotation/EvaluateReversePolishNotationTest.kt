package me.bossm0n5t3r.leetcode.evaluateReversePolishNotation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EvaluateReversePolishNotationTest {
    private val sut = EvaluateReversePolishNotation.Solution()

    private data class TestData(val tokens: Array<String>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!tokens.contentEquals(other.tokens)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = tokens.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(arrayOf("2", "1", "+", "3", "*"), 9),
                TestData(arrayOf("4", "13", "5", "/", "+"), 6),
                TestData(
                    arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"),
                    22,
                ),
            )

        tests.forEach { test -> assertEquals(test.result, sut.evalRPN(test.tokens)) }
    }
}
