package me.bossm0n5t3r.leetcode.deleteTheMiddleNodeOfALinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DeleteTheMiddleNodeOfALinkedListTest {
    private val sut = DeleteTheMiddleNodeOfALinkedList.Solution()

    private data class TestData(val head: ListNode?, val result: ListNode?)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    ListNodeUtil.generateListNode(1, 3, 4, 7, 1, 2, 6),
                    ListNodeUtil.generateListNode(1, 3, 4, 1, 2, 6),
                ),
                TestData(
                    ListNodeUtil.generateListNode(1, 2, 3, 4),
                    ListNodeUtil.generateListNode(1, 2, 4),
                ),
                TestData(ListNodeUtil.generateListNode(2, 1), ListNodeUtil.generateListNode(2)),
                TestData(ListNodeUtil.generateListNode(1), ListNodeUtil.generateListNode()),
            )

        tests.forEach { test ->
            val result = sut.deleteMiddle(test.head)
            ListNodeUtil.printListNode(result)
            ListNodeUtil.printListNode(test.result)
            assertTrue { ListNodeUtil.isEqual(result, test.result) }
        }
    }
}
