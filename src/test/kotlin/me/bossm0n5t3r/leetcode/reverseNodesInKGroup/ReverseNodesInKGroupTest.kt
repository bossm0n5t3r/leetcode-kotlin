package me.bossm0n5t3r.leetcode.reverseNodesInKGroup

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ReverseNodesInKGroupTest {
    private val sut = ReverseNodesInKGroup.Solution()

    private data class TestData(val head: ListNode?, val k: Int, val result: ListNode?)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    ListNodeUtil.generateListNode(1, 2, 3, 4, 5),
                    2,
                    ListNodeUtil.generateListNode(2, 1, 4, 3, 5),
                ),
                TestData(
                    ListNodeUtil.generateListNode(1, 2, 3, 4, 5),
                    3,
                    ListNodeUtil.generateListNode(3, 2, 1, 4, 5),
                ),
            )

        tests.forEach { test ->
            assertTrue { ListNodeUtil.isEqual(sut.reverseKGroup(test.head, test.k), test.result) }
        }
    }
}
