package me.bossm0n5t3r.leetcode.maximummatchingofplayerswithtrainers

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumMatchingOfPlayersWithTrainersTest {
    private val sut = MaximumMatchingOfPlayersWithTrainers.Solution()

    private data class TestData(val players: IntArray, val trainers: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!players.contentEquals(other.players)) return false
            if (!trainers.contentEquals(other.trainers)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + players.contentHashCode()
            result1 = 31 * result1 + trainers.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[4,7,9]".toIntArray(), "[8,2,5,8]".toIntArray(), 2),
                TestData("[1,1,1]".toIntArray(), "[10]".toIntArray(), 1),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.matchPlayersAndTrainers(testData.players, testData.trainers),
            )
        }
    }
}
