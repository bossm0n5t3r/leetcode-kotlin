package me.bossm0n5t3r.leetcode.countlargestgroup

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountLargestGroupTest {
    private val sut = CountLargestGroup.Solution()

    private data class TestData(val n: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData(13, 4), TestData(2, 2))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.countLargestGroup(testData.n))
        }
    }
}
