package me.bossm0n5t3r.leetcode.checkifawordoccursasaprefixofanywordinasentence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheckIfAWordOccursAsAPrefixOfAnyWordInASentenceTest {
    private val sut = CheckIfAWordOccursAsAPrefixOfAnyWordInASentence.Solution()

    private data class TestData(val sentence: String, val searchWord: String, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("i love eating burger", "burg", 4),
                TestData("this problem is an easy problem", "pro", 2),
                TestData("i am tired", "you", -1),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.isPrefixOfWord(testData.sentence, testData.searchWord),
            )
        }
    }
}
