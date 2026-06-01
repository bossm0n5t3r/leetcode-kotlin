package me.bossm0n5t3r.leetcode.partitioningintominimumnumberofdecibinarynumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PartitioningIntoMinimumNumberOfDeciBinaryNumbersTest {
    private val sut = PartitioningIntoMinimumNumberOfDeciBinaryNumbers.Solution()

    private data class TestData(val n: String, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(TestData("32", 3), TestData("82734", 8), TestData("27346209830709182346", 9))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minPartitions(testData.n))
        }
    }
}
