package me.bossm0n5t3r.leetcode.findtheminimumandmaximumnumberofnodesbetweencriticalpoints

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPointsTest {
    private val sut = FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints.Solution()

    private data class TestData(val head: ListNode?, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (head != other.head) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = head.hashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(ListNodeUtil.generateListNode(3, 1), intArrayOf(-1, -1)),
                TestData(ListNodeUtil.generateListNode(5, 3, 1, 2, 5, 1, 2), intArrayOf(1, 3)),
                TestData(ListNodeUtil.generateListNode(1, 3, 2, 2, 3, 2, 2, 2, 7), intArrayOf(3, 3)),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result.toList(),
                sut.nodesBetweenCriticalPoints(testData.head).toList(),
            )
        }
    }
}
