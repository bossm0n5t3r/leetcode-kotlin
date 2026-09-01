package me.bossm0n5t3r.leetcode.minimummovestocleantheclassroom

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfString
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumMovesToCleanTheClassroomTest {
    private val sut = MinimumMovesToCleanTheClassroom.Solution()

    private data class TestData(val classroom: Array<String>, val energy: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (energy != other.energy) return false
            if (result != other.result) return false
            if (!classroom.contentEquals(other.classroom)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = energy
            result1 = 31 * result1 + result
            result1 = 31 * result1 + classroom.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[\"S.\", \"XL\"]".toArrayOfString(), 2, 2),
                TestData("[\"LS\", \"RL\"]".toArrayOfString(), 4, 3),
                TestData("[\"L.S\", \"RXL\"]".toArrayOfString(), 3, -1),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minMoves(testData.classroom, testData.energy))
        }
    }
}
