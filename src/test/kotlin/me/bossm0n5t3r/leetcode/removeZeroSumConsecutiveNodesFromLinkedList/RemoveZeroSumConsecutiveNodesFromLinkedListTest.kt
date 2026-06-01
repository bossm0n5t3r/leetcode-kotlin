package me.bossm0n5t3r.leetcode.removeZeroSumConsecutiveNodesFromLinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RemoveZeroSumConsecutiveNodesFromLinkedListTest {
    private val sut = RemoveZeroSumConsecutiveNodesFromLinkedList.Solution()

    private data class TestData(val head: ListNode?, val result: ListNode?)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    ListNodeUtil.generateListNode(1, 2, -3, 3, 1),
                    ListNodeUtil.generateListNode(3, 1),
                ),
                TestData(
                    ListNodeUtil.generateListNode(1, 2, 3, -3, 4),
                    ListNodeUtil.generateListNode(1, 2, 4),
                ),
                TestData(
                    ListNodeUtil.generateListNode(1, 2, 3, -3, -2),
                    ListNodeUtil.generateListNode(1),
                ),
                TestData(
                    ListNodeUtil.generateListNode(1, 3, 2, -3, -2, 5, 5, -5, 1),
                    ListNodeUtil.generateListNode(1, 5, 1),
                ),
                TestData(ListNodeUtil.generateListNode(0, 0), ListNodeUtil.generateListNode()),
                TestData(
                    ListNodeUtil.generateListNode(-1, 1, 0, 1),
                    ListNodeUtil.generateListNode(1),
                ),
                TestData(
                    ListNodeUtil.generateListNode(2, 2, -2, 1, -1, -1),
                    ListNodeUtil.generateListNode(2, -1),
                ),
                TestData(
                    ListNodeUtil.generateListNode(-1, -2, 0, -1, 2, 2, -1, 1),
                    ListNodeUtil.generateListNode(),
                ),
            )

        tests.forEach { test ->
            assertTrue(ListNodeUtil.isEqual(sut.removeZeroSumSublists(test.head), test.result))
        }
    }
}
