package me.bossm0n5t3r.leetcode.validParenthesisString

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidParenthesisStringTest {
    private val sut = ValidParenthesisString.Solution()

    private data class TestData(val s: String, val result: Boolean)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("()", true),
                TestData("(*)", true),
                TestData("(*))", true),
                TestData(
                    "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()",
                    true,
                ),
                TestData(
                    "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())",
                    false,
                ),
                TestData("()(()((())))()((*)*)()()(()()((()())))*()*()((()()", false),
                TestData(
                    "()*()**()(())(()()(())*)()((()**))()()()(((*(((*)))(**))**))()(()()(()))()((())(*()())())()(*",
                    true,
                ),
            )

        tests.forEach { test -> assertEquals(test.result, sut.checkValidString(test.s)) }
    }
}
