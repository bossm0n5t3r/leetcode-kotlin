package me.bossm0n5t3r.leetcode.letterCombinationsOfAPhoneNumber

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LetterCombinationsOfAPhoneNumberTest {
    private val letterCombinationsOfAPhoneNumber = LetterCombinationsOfAPhoneNumber.Solution()

    private data class LetterCombinationsOfAPhoneNumberTestData(
        val digits: String,
        val result: List<String>,
    )

    @Test
    fun letterCombinations() {
        val tests =
            listOf(
                LetterCombinationsOfAPhoneNumberTestData(
                    "23",
                    listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"),
                ),
                LetterCombinationsOfAPhoneNumberTestData("", emptyList()),
                LetterCombinationsOfAPhoneNumberTestData("2", listOf("a", "b", "c")),
            )
        tests.forEach { test ->
            println(letterCombinationsOfAPhoneNumber.letterCombinations(test.digits))
            assertThat(letterCombinationsOfAPhoneNumber.letterCombinations(test.digits))
                .containsExactlyInAnyOrderElementsOf(test.result)

            println(letterCombinationsOfAPhoneNumber.letterCombinationsGoodSolution(test.digits))
            assertThat(letterCombinationsOfAPhoneNumber.letterCombinationsGoodSolution(test.digits))
                .containsExactlyInAnyOrderElementsOf(test.result)

            println(letterCombinationsOfAPhoneNumber.letterCombinationsAt230829(test.digits))
            assertThat(letterCombinationsOfAPhoneNumber.letterCombinationsAt230829(test.digits))
                .containsExactlyInAnyOrderElementsOf(test.result)
        }
    }
}
