package me.bossm0n5t3r.leetcode.findthesafestpathinagrid

import me.bossm0n5t3r.leetcode.utils.StringUtil.toListOfIntList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheSafestPathInAGridTest {
    private val sut = FindTheSafestPathInAGrid.Solution()

    private data class TestData(val grid: List<List<Int>>, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[[1,0,0],[0,0,0],[0,0,1]]".toListOfIntList(), 0),
                TestData("[[0,0,1],[0,0,0],[0,0,0]]".toListOfIntList(), 2),
                TestData("[[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]".toListOfIntList(), 2),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maximumSafenessFactor(testData.grid))
        }
    }
}
