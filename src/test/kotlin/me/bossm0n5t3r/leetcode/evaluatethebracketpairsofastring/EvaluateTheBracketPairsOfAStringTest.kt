package me.bossm0n5t3r.leetcode.evaluatethebracketpairsofastring

import me.bossm0n5t3r.leetcode.utils.StringUtil.toListOfStringList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EvaluateTheBracketPairsOfAStringTest {
    private val sut = EvaluateTheBracketPairsOfAString.Solution()

    private class TestData(val s: String, val knowledge: List<List<String>>, val result: String)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "(name)is(age)yearsold",
                    "[[\"name\",\"bob\"],[\"age\",\"two\"]]".toListOfStringList(),
                    "bobistwoyearsold",
                ),
                TestData("hi(name)", "[[\"a\",\"b\"]]".toListOfStringList(), "hi?"),
                TestData("(a)(a)(a)aaa", "[[\"a\",\"yes\"]]".toListOfStringList(), "yesyesyesaaa"),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.evaluate(testData.s, testData.knowledge))
        }
    }
}
