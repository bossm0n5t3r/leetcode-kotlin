package me.bossm0n5t3r.leetcode.fractionAdditionAndSubtraction

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FractionAdditionAndSubtractionTest {
    private val sut = FractionAdditionAndSubtraction.Solution()

    private data class TestData(val expression: String, val result: String)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("-1/2+1/2", "0/1"),
                TestData("-1/2+1/2+1/3", "1/3"),
                TestData("1/3-1/2", "-1/6"),
            )

        tests.forEach { test -> assertEquals(test.result, sut.fractionAddition(test.expression)) }
    }
}
