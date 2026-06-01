package me.bossm0n5t3r.leetcode.dominoAndTrominoTiling

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DominoAndTrominoTilingTest {
    private val sut = DominoAndTrominoTiling.Solution()

    private data class TestData(val n: Int, val result: Int)

    @Test
    fun test() {
        val tests = listOf(TestData(3, 5), TestData(1, 1), TestData(4, 11), TestData(60, 882347204))

        tests.forEach { test -> assertEquals(test.result, sut.numTilings(test.n)) }
    }
}
