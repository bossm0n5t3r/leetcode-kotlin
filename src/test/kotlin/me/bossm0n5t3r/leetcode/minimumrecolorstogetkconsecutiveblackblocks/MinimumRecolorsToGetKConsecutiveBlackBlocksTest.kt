package me.bossm0n5t3r.leetcode.minimumrecolorstogetkconsecutiveblackblocks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumRecolorsToGetKConsecutiveBlackBlocksTest {
    private val sut = MinimumRecolorsToGetKConsecutiveBlackBlocks.Solution()

    private data class TestData(val blocks: String, val k: Int, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("WBBWWBBWBW", 7, 3),
                TestData("WBWBBBW", 2, 0),
                TestData("WBBWWWWBBWWBBBBWWBBWWBBBWWBBBWWWBWBWW", 15, 6),
                TestData("BWWWBB", 6, 3),
                TestData(
                    "BBBBBWWBBWBWBWWWBWBWBBBBWBBBBWBWBWBWBWWBWWBWBWWWWBBWWWWBWWWWBWBBWBBWBBWWW",
                    29,
                    10,
                ),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minimumRecolors(testData.blocks, testData.k))
        }
    }
}
