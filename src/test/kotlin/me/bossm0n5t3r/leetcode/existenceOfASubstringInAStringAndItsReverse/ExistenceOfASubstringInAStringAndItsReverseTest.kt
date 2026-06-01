package me.bossm0n5t3r.leetcode.existenceOfASubstringInAStringAndItsReverse

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ExistenceOfASubstringInAStringAndItsReverseTest {
    private val sut = ExistenceOfASubstringInAStringAndItsReverse.Solution()

    private data class TestData(val s: String, val result: Boolean)

    @Test
    fun test() {
        val tests =
            listOf(TestData("leetcode", true), TestData("abcba", true), TestData("abcd", false))

        tests.forEach { test -> assertEquals(test.result, sut.isSubstringPresent(test.s)) }
    }
}
