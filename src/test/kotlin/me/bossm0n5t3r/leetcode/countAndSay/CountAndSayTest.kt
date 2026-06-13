package me.bossm0n5t3r.leetcode.countAndSay

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountAndSayTest {
    private val countAndSay = CountAndSay.Solution()

    data class CountAndSayTestData(val n: Int, val result: String)

    @Test
    fun countAndSay() {
        val tests =
            listOf(
                CountAndSayTestData(1, "1"),
                CountAndSayTestData(4, "1211"),
                CountAndSayTestData(5, "111221"),
            )
        tests.forEach { test -> assertEquals(test.result, countAndSay.countAndSay(test.n)) }
    }
}
