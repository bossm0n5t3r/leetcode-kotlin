package me.bossm0n5t3r.leetcode.weightedwordmapping

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WeightedWordMappingTest {
    private val sut = WeightedWordMapping.Solution()

    private data class TestData(
        val words: Array<String>,
        val weights: IntArray,
        val result: String,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!words.contentEquals(other.words)) return false
            if (!weights.contentEquals(other.weights)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = words.contentHashCode()
            result1 = 31 * result1 + weights.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    arrayOf("abcd", "def", "xyz"),
                    intArrayOf(
                        5,
                        3,
                        12,
                        14,
                        1,
                        2,
                        3,
                        2,
                        10,
                        6,
                        6,
                        9,
                        7,
                        8,
                        7,
                        10,
                        8,
                        9,
                        6,
                        9,
                        9,
                        8,
                        3,
                        7,
                        7,
                        2,
                    ),
                    "rij",
                ),
                TestData(
                    arrayOf("a", "b", "c"),
                    intArrayOf(
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
                        1,
                    ),
                    "yyy",
                ),
                TestData(
                    arrayOf("abcd"),
                    intArrayOf(
                        7,
                        5,
                        3,
                        4,
                        3,
                        5,
                        4,
                        9,
                        4,
                        2,
                        2,
                        7,
                        10,
                        2,
                        5,
                        10,
                        6,
                        1,
                        2,
                        2,
                        4,
                        1,
                        3,
                        4,
                        4,
                        5,
                    ),
                    "g",
                ),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.mapWordWeights(testData.words, testData.weights))
        }
    }
}
