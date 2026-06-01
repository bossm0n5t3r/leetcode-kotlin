package me.bossm0n5t3r.leetcode.replaceWords

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReplaceWordsTest {
    private val sut = ReplaceWords.Solution()

    private data class TestData(
        val dictionary: List<String>,
        val sentence: String,
        val result: String,
    )

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    listOf("cat", "bat", "rat"),
                    "the cattle was rattled by the battery",
                    "the cat was rat by the bat",
                ),
                TestData(listOf("a", "b", "c"), "aadsfasf absbs bbab cadsfafs", "a a b c"),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.replaceWords(test.dictionary, test.sentence))
        }
    }
}
