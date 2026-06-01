package me.bossm0n5t3r.leetcode.removeNodesFromLinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RemoveNodesFromLinkedListTest {
    private val sut = RemoveNodesFromLinkedList.Solution()

    private data class TestData(val head: ListNode?, val result: ListNode?)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    ListNodeUtil.generateListNode(5, 2, 13, 3, 8),
                    ListNodeUtil.generateListNode(13, 8),
                ),
                TestData(
                    ListNodeUtil.generateListNode(1, 1, 1, 1),
                    ListNodeUtil.generateListNode(1, 1, 1, 1),
                ),
            )

        tests.forEach { test ->
            assertTrue { ListNodeUtil.isEqual(test.result, sut.removeNodes(test.head)) }
        }
    }
}
