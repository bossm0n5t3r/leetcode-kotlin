package me.bossm0n5t3r.leetcode.lexicographicalnumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicalNumbersTest {
    private val sut = LexicographicalNumbers.Solution()

    private data class TestData(val n: Int, val result: List<Int>)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(13, listOf(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9)),
                TestData(2, listOf(1, 2)),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.lexicalOrder(testData.n))
        }
    }
}
