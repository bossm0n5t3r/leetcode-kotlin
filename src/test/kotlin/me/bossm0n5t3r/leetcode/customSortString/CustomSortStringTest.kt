package me.bossm0n5t3r.leetcode.customSortString

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CustomSortStringTest {
    private val sut = CustomSortString.Solution()

    private data class TestData(val order: String, val s: String, val result: String)

    @Test
    fun test() {
        val tests = listOf(TestData("cba", "abcd", "cbad"), TestData("bcafg", "abcd", "bcad"))

        tests.forEach { test ->
            assertEquals(test.result, sut.customSortString(test.order, test.s))
        }
    }
}
