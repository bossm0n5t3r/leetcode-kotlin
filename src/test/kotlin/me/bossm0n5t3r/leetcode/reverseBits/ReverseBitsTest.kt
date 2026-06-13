package me.bossm0n5t3r.leetcode.reverseBits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseBitsTest {
    private val reverseBits = ReverseBits.Solution()

    data class ReverseBitsTestData(val n: Int, val result: Int)

    @Test
    fun reverseBits() {
        val tests =
            listOf(ReverseBitsTestData(43261596, 964176192), ReverseBitsTestData(-3, -1073741825))
        tests.forEach { test -> assertEquals(test.result, reverseBits.reverseBits(test.n)) }
    }
}
