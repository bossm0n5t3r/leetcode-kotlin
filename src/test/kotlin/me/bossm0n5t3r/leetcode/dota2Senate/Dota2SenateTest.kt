package me.bossm0n5t3r.leetcode.dota2Senate

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Dota2SenateTest {
    private val sut = Dota2Senate.Solution()

    private data class TestData(val senate: String, val result: String)

    @Test
    fun test() {
        val tests = listOf(TestData("RD", "Radiant"), TestData("RDD", "Dire"))

        tests.forEach { test -> assertEquals(test.result, sut.predictPartyVictory(test.senate)) }
    }
}
