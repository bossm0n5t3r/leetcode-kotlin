package me.bossm0n5t3r.leetcode.numberOfCommonFactors

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfCommonFactorsTest {
    private val sut = NumberOfCommonFactors.Solution()

    private data class TestData(val a: Int, val b: Int, val result: Int)

    @Test
    fun test() {
        val tests = listOf(TestData(12, 6, 4), TestData(25, 30, 2))

        tests.forEach { test -> assertEquals(test.result, sut.commonFactors(test.a, test.b)) }
    }
}
