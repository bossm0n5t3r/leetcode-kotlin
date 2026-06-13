package me.bossm0n5t3r.leetcode.deleteNodeInALinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeleteNodeInALinkedListTest {
    private lateinit var deleteNodeInALinkedList: DeleteNodeInALinkedList.Solution

    data class DeleteNodeInALinkedListTestData(
        val head: ListNode?,
        val node: Int,
        val result: List<Int>,
    )

    @Test
    fun deleteNode() {
        val tests =
            listOf(
                DeleteNodeInALinkedListTestData(
                    head = ListNodeUtil.generateListNode(4, 5, 1, 9),
                    node = 5,
                    result = listOf(4, 1, 9),
                ),
                DeleteNodeInALinkedListTestData(
                    head = ListNodeUtil.generateListNode(4, 5, 1, 9),
                    node = 1,
                    result = listOf(4, 5, 9),
                ),
                DeleteNodeInALinkedListTestData(
                    head = ListNodeUtil.generateListNode(1, 2, 3, 4),
                    node = 3,
                    result = listOf(1, 2, 4),
                ),
                DeleteNodeInALinkedListTestData(
                    head = ListNodeUtil.generateListNode(0, 1),
                    node = 0,
                    result = listOf(1),
                ),
                DeleteNodeInALinkedListTestData(
                    head = ListNodeUtil.generateListNode(-3, 5, -99),
                    node = -3,
                    result = listOf(5, -99),
                ),
            )
        tests.forEach { test ->
            val node = ListNodeUtil.findListNodeByValue(test.node, test.head!!)
            deleteNodeInALinkedList = DeleteNodeInALinkedList.Solution(test.head)
            deleteNodeInALinkedList.deleteNode(node)
            assertEquals(test.result, ListNodeUtil.listNodeToList(deleteNodeInALinkedList.head))
        }
    }
}
