package me.bossm0n5t3r.leetcode.linkedListInBinaryTree

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LinkedListInBinaryTreeTest {
    private val sut = LinkedListInBinaryTree.Solution()

    private data class TestData(val head: ListNode?, val root: TreeNode?, val result: Boolean)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    ListNodeUtil.generateListNode(4, 2, 8),
                    TreeNodeUtil.generateTreeNodeOrNull(
                        listOf(
                            1,
                            4,
                            4,
                            null,
                            2,
                            2,
                            null,
                            1,
                            null,
                            6,
                            8,
                            null,
                            null,
                            null,
                            null,
                            1,
                            3,
                        )
                    ),
                    true,
                ),
                TestData(
                    ListNodeUtil.generateListNode(1, 4, 2, 6),
                    TreeNodeUtil.generateTreeNodeOrNull(
                        listOf(
                            1,
                            4,
                            4,
                            null,
                            2,
                            2,
                            null,
                            1,
                            null,
                            6,
                            8,
                            null,
                            null,
                            null,
                            null,
                            1,
                            3,
                        )
                    ),
                    true,
                ),
                TestData(
                    ListNodeUtil.generateListNode(1, 4, 2, 6, 8),
                    TreeNodeUtil.generateTreeNodeOrNull(
                        listOf(
                            1,
                            4,
                            4,
                            null,
                            2,
                            2,
                            null,
                            1,
                            null,
                            6,
                            8,
                            null,
                            null,
                            null,
                            null,
                            1,
                            3,
                        )
                    ),
                    false,
                ),
            )

        tests.forEach { test -> assertEquals(test.result, sut.isSubPath(test.head, test.root)) }
    }
}
