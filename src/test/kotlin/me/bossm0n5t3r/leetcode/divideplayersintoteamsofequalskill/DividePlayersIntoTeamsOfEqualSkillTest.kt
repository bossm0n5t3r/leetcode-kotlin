package me.bossm0n5t3r.leetcode.divideplayersintoteamsofequalskill

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DividePlayersIntoTeamsOfEqualSkillTest {
    private val sut = DividePlayersIntoTeamsOfEqualSkill.Solution()

    private data class TestData(val skill: IntArray, val result: Long) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!skill.contentEquals(other.skill)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = skill.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(3, 2, 5, 1, 3, 4), 22),
                TestData(intArrayOf(3, 4), 12),
                TestData(intArrayOf(1, 1, 2, 3), -1),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.dividePlayers(testData.skill))
        }
    }
}
