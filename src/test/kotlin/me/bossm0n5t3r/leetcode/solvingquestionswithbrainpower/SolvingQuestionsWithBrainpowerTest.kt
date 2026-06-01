package me.bossm0n5t3r.leetcode.solvingquestionswithbrainpower

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolvingQuestionsWithBrainpowerTest {
    private val sut = SolvingQuestionsWithBrainpower.Solution()

    private data class TestData(val questions: Array<IntArray>, val result: Long) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!questions.contentDeepEquals(other.questions)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result.hashCode()
            result1 = 31 * result1 + questions.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[[3,2],[4,3],[4,4],[2,5]]".toArrayOfIntArray(), 5),
                TestData("[[1,1],[2,2],[3,3],[4,4],[5,5]]".toArrayOfIntArray(), 7),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.mostPoints(testData.questions))
        }
    }
}
