package me.bossm0n5t3r.leetcode.mergeNodesInBetweenZeros

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MergeNodesInBetweenZerosTest {
    private val sut = MergeNodesInBetweenZeros.Solution()

    private data class TestData(val head: ListNode?, val result: ListNode?)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    ListNodeUtil.generateListNode(0, 3, 1, 0, 4, 5, 2, 0),
                    ListNodeUtil.generateListNode(4, 11),
                ),
                TestData(
                    ListNodeUtil.generateListNode(0, 1, 0, 3, 0, 2, 2, 0),
                    ListNodeUtil.generateListNode(1, 3, 4),
                ),
            )

        tests.forEach { test ->
            assertTrue { ListNodeUtil.isEqual(sut.mergeNodes(test.head), test.result) }
        }
    }
}
