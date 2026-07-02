package me.bossm0n5t3r.leetcode.findasafewalkthroughagrid

import me.bossm0n5t3r.leetcode.utils.StringUtil.toListOfIntList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindASafeWalkThroughAGridTest {
    private val sut = FindASafeWalkThroughAGrid.Solution()

    private data class TestData(val grid: List<List<Int>>, val health: Int, val result: Boolean)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]".toListOfIntList(), 1, true),
                TestData(
                    "[[0,1,1,0,0,0],[1,0,1,0,0,0],[0,1,1,1,0,1],[0,0,1,0,1,0]]".toListOfIntList(),
                    3,
                    false,
                ),
                TestData("[[1,1,1],[1,0,1],[1,1,1]]".toListOfIntList(), 5, true),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.findSafeWalk(testData.grid, testData.health),
                "testData.grid=${testData.grid}",
            )
        }
    }
}
