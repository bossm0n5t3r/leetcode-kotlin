package me.bossm0n5t3r.leetcode.integerToRoman

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class IntegerToRomanTest {
    private val integerToRoman = IntegerToRoman.Solution()

    private data class IntegerToRomanTestData(val num: Int, val result: String)

    @Test
    fun intToRoman() {
        val tests =
            listOf(
                IntegerToRomanTestData(3, "III"),
                IntegerToRomanTestData(4, "IV"),
                IntegerToRomanTestData(9, "IX"),
                IntegerToRomanTestData(58, "LVIII"),
                IntegerToRomanTestData(1994, "MCMXCIV"),
                IntegerToRomanTestData(3999, "MMMCMXCIX"),
            )
        tests.forEach { test ->
            assertEquals(test.result, integerToRoman.intToRoman(test.num))
            assertEquals(test.result, integerToRoman.intToRomanAt20250109(test.num))
        }
    }
}
