package me.bossm0n5t3r.leetcode.removeNthNodeFromEndOfList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class RemoveNthNodeFromEndOfListTest {
    private val removeNthNodeFromEndOfList = RemoveNthNodeFromEndOfList.Solution()

    private data class RemoveNthNodeFromEndOfListTestData(
        val head: ListNode?,
        val n: Int,
        val result: ListNode?,
    )

    @Test
    fun removeNthFromEnd() {
        val tests =
            listOf(
                RemoveNthNodeFromEndOfListTestData(
                    ListNodeUtil.generateListNode(1, 2, 3, 4, 5),
                    2,
                    ListNodeUtil.generateListNode(1, 2, 3, 5),
                ),
                RemoveNthNodeFromEndOfListTestData(
                    ListNodeUtil.generateListNode(1),
                    1,
                    ListNodeUtil.generateListNode(),
                ),
                RemoveNthNodeFromEndOfListTestData(
                    ListNodeUtil.generateListNode(1, 2),
                    1,
                    ListNodeUtil.generateListNode(1),
                ),
            )
        tests.forEach { test ->
            val result = removeNthNodeFromEndOfList.removeNthFromEnd(test.head, test.n)
            ListNodeUtil.printListNode(result)
            assertTrue(ListNodeUtil.isEqual(result, test.result))

            val resultUsingPointers =
                removeNthNodeFromEndOfList.removeNthFromEndUsingPointers(test.head, test.n)
            ListNodeUtil.printListNode(resultUsingPointers)
            assertTrue(ListNodeUtil.isEqual(resultUsingPointers, test.result))
        }
    }
}
