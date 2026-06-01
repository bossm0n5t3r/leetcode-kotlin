package me.bossm0n5t3r.leetcode.totalcharactersinstringaftertransformationsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalCharactersInStringAfterTransformationsIITest {
    private val sut = TotalCharactersInStringAfterTransformationsII.Solution()

    private data class TestData(val s: String, val t: Int, val nums: List<Int>, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "abcyy",
                    2,
                    listOf(
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        2,
                    ),
                    7,
                ),
                TestData(
                    "azbk",
                    1,
                    listOf(
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                    ),
                    8,
                ),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.lengthAfterTransformations(testData.s, testData.t, testData.nums),
            )
        }
    }
}
