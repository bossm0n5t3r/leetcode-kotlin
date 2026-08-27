package me.bossm0n5t3r.leetcode.courseschedule

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CourseScheduleTest {
    private val sut = CourseSchedule.Solution()

    private data class TestData(
        val numCourses: Int,
        val prerequisites: Array<IntArray>,
        val result: Boolean,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (numCourses != other.numCourses) return false
            if (result != other.result) return false
            if (!prerequisites.contentDeepEquals(other.prerequisites)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = numCourses
            result1 = 31 * result1 + result.hashCode()
            result1 = 31 * result1 + prerequisites.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(2, "[[1,0]]".toArrayOfIntArray(), true),
                TestData(2, "[[1,0],[0,1]]".toArrayOfIntArray(), false),
                TestData(5, "[[1,4],[2,4],[3,1],[3,2]]".toArrayOfIntArray(), true),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.canFinish(testData.numCourses, testData.prerequisites),
            )
        }
    }
}
