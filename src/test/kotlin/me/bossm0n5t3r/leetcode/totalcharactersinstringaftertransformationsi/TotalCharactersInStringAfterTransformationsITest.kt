package me.bossm0n5t3r.leetcode.totalcharactersinstringaftertransformationsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalCharactersInStringAfterTransformationsITest {
    private val sut = TotalCharactersInStringAfterTransformationsI.Solution()

    private data class TestData(val s: String, val t: Int, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("abcyy", 2, 7),
                TestData("azbk", 1, 5),
                TestData("jqktcurgdvlibczdsvnsg", 7517, 79033769),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.lengthAfterTransformations(testData.s, testData.t))
        }
    }
}
