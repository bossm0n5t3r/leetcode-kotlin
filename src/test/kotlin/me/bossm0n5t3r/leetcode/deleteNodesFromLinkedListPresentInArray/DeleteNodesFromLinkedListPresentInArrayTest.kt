package me.bossm0n5t3r.leetcode.deleteNodesFromLinkedListPresentInArray

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DeleteNodesFromLinkedListPresentInArrayTest {
    private val sut = DeleteNodesFromLinkedListPresentInArray.Solution()

    private data class TestData(val nums: IntArray, val head: ListNode?, val result: ListNode?) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (head != other.head) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + (head?.hashCode() ?: 0)
            result1 = 31 * result1 + (result?.hashCode() ?: 0)
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    intArrayOf(1, 2, 3),
                    ListNodeUtil.generateListNode(1, 2, 3, 4, 5),
                    ListNodeUtil.generateListNode(4, 5),
                ),
                TestData(
                    intArrayOf(1),
                    ListNodeUtil.generateListNode(1, 2, 1, 2, 1, 2),
                    ListNodeUtil.generateListNode(2, 2, 2),
                ),
                TestData(
                    intArrayOf(5),
                    ListNodeUtil.generateListNode(1, 2, 3, 4),
                    ListNodeUtil.generateListNode(1, 2, 3, 4),
                ),
            )

        tests.forEach { test ->
            assertTrue { ListNodeUtil.isEqual(sut.modifiedList(test.nums, test.head), test.result) }
        }
    }
}
