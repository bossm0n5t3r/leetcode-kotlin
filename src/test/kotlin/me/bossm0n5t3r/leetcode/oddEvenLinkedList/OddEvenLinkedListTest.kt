package me.bossm0n5t3r.leetcode.oddEvenLinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class OddEvenLinkedListTest {
    private val oddEvenLinkedList = OddEvenLinkedList.Solution()

    data class OddEvenLinkedListTestData(val head: ListNode?, val result: ListNode?)

    @Test
    fun oddEvenList() {
        val tests =
            listOf(
                OddEvenLinkedListTestData(
                    head = ListNodeUtil.generateListNode(1, 2, 3, 4, 5),
                    result = ListNodeUtil.generateListNode(1, 3, 5, 2, 4),
                ),
                OddEvenLinkedListTestData(
                    head = ListNodeUtil.generateListNode(2, 1, 3, 5, 6, 4, 7),
                    result = ListNodeUtil.generateListNode(2, 3, 6, 7, 1, 5, 4),
                ),
                OddEvenLinkedListTestData(
                    head = ListNodeUtil.generateListNode(1, 2, 3, 4, 5, 6, 7, 8),
                    result = ListNodeUtil.generateListNode(1, 3, 5, 7, 2, 4, 6, 8),
                ),
                OddEvenLinkedListTestData(
                    head = ListNodeUtil.generateListNode(1, 1),
                    result = ListNodeUtil.generateListNode(1, 1),
                ),
            )
        tests.forEach { test ->
            assertTrue(ListNodeUtil.isEqual(oddEvenLinkedList.oddEvenList(test.head), test.result))
        }
    }
}
