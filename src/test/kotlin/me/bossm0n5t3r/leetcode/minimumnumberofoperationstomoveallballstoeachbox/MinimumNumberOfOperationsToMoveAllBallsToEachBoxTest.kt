package me.bossm0n5t3r.leetcode.minimumnumberofoperationstomoveallballstoeachbox

import org.junit.jupiter.api.Test

class MinimumNumberOfOperationsToMoveAllBallsToEachBoxTest {
    private val sut = MinimumNumberOfOperationsToMoveAllBallsToEachBox.Solution()

    private data class TestData(val boxes: String, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (boxes != other.boxes) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = boxes.hashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("110", intArrayOf(1, 1, 3)),
                TestData("001011", intArrayOf(11, 8, 5, 4, 3, 4)),
            )

        for (testData in testDataList) {
            testData.result.contentEquals(sut.minOperations(testData.boxes))
        }
    }
}
