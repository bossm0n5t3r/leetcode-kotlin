package me.bossm0n5t3r.leetcode.palindromePartitioning

import me.bossm0n5t3r.leetcode.utils.StringUtil.toListOfStringList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PalindromePartitioningTest {
    private val sut = PalindromePartitioning.Solution()

    private data class TestData(val s: String, val result: List<List<String>>)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("aab", "[[\"a\",\"a\",\"b\"],[\"aa\",\"b\"]]".toListOfStringList()),
                TestData("a", "[[\"a\"]]".toListOfStringList()),
            )

        tests.forEach { test -> assertEquals(test.result, sut.partition(test.s)) }
    }
}
