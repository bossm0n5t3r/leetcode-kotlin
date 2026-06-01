package me.bossm0n5t3r.leetcode.reverseonlyletters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseOnlyLettersTest {
    private val sut = ReverseOnlyLetters.Solution()

    private data class TestData(val s: String, val result: String)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("ab-cd", "dc-ba"),
                TestData("a-bC-dEf-ghIj", "j-Ih-gfE-dCba"),
                TestData("Test1ng-Leet=code-Q!", "Qedo1ct-eeLg=ntse-T!"),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.reverseOnlyLetters(testData.s))
        }
    }
}
