package me.bossm0n5t3r.leetcode.constructsmallestnumberfromdistring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConstructSmallestNumberFromDIStringTest {
    private val sut = ConstructSmallestNumberFromDIString.Solution()

    private data class TestData(val pattern: String, val result: String)

    @Test
    fun test() {
        val testDataList = listOf(TestData("IIIDIDDD", "123549876"), TestData("DDD", "4321"))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.smallestNumber(testData.pattern))
        }
    }
}
