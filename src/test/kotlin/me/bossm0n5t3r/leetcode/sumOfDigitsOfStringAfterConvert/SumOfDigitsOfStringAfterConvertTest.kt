package me.bossm0n5t3r.leetcode.sumOfDigitsOfStringAfterConvert

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfDigitsOfStringAfterConvertTest {
    private val sut = SumOfDigitsOfStringAfterConvert.Solution()

    private data class TestData(val s: String, val k: Int, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(TestData("iiii", 1, 36), TestData("leetcode", 2, 6), TestData("zbax", 2, 8))

        tests.forEach { test -> assertEquals(test.result, sut.getLucky(test.s, test.k)) }
    }
}
