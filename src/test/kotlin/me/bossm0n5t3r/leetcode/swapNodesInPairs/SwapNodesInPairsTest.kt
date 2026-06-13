package me.bossm0n5t3r.leetcode.swapNodesInPairs

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class SwapNodesInPairsTest {
    private val swapNodesInPairs = SwapNodesInPairs.Solution()

    private data class SwapNodesInPairsTestData(val head: ListNode?, val result: ListNode?)

    @Test
    fun swapPairs() {
        val tests =
            listOf(
                SwapNodesInPairsTestData(
                    ListNodeUtil.generateListNode(1, 2, 3, 4),
                    ListNodeUtil.generateListNode(2, 1, 4, 3),
                ),
                SwapNodesInPairsTestData(
                    ListNodeUtil.generateListNode(),
                    ListNodeUtil.generateListNode(),
                ),
                SwapNodesInPairsTestData(
                    ListNodeUtil.generateListNode(1),
                    ListNodeUtil.generateListNode(1),
                ),
                SwapNodesInPairsTestData(
                    ListNodeUtil.generateListNode(1, 2, 3),
                    ListNodeUtil.generateListNode(2, 1, 3),
                ),
            )
        tests.forEach { test ->
            val result = swapNodesInPairs.swapPairs(test.head)
            assertTrue(ListNodeUtil.isEqual(result, test.result))
        }
    }
}
