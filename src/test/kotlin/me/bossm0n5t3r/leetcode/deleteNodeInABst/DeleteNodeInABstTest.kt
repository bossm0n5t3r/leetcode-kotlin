package me.bossm0n5t3r.leetcode.deleteNodeInABst

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DeleteNodeInABstTest {
    private val sut = DeleteNodeInABst.Solution()

    private data class TestData(val root: TreeNode?, val key: Int, val result: TreeNode?)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    root = TreeNodeUtil.generateTreeNodeOrNull(listOf(5, 3, 6, 2, 4, null, 7)),
                    key = 3,
                    result = TreeNodeUtil.generateTreeNodeOrNull(listOf(5, 4, 6, 2, null, null, 7)),
                ),
                TestData(
                    root = TreeNodeUtil.generateTreeNodeOrNull(listOf(5, 3, 6, 2, 4, null, 7)),
                    key = 0,
                    result = TreeNodeUtil.generateTreeNodeOrNull(listOf(5, 3, 6, 2, 4, null, 7)),
                ),
                TestData(
                    root = TreeNodeUtil.generateTreeNodeOrNull(listOf()),
                    key = 0,
                    result = TreeNodeUtil.generateTreeNodeOrNull(listOf()),
                ),
                TestData(
                    root = TreeNodeUtil.generateTreeNodeOrNull(listOf(0)),
                    key = 0,
                    result = TreeNodeUtil.generateTreeNodeOrNull(listOf()),
                ),
                TestData(
                    root = TreeNodeUtil.generateTreeNodeOrNull(listOf(5, 3, 6, 2, 4, null, 7)),
                    key = 5,
                    result = TreeNodeUtil.generateTreeNodeOrNull(listOf(6, 3, 7, 2, 4)),
                ),
                TestData(
                    root = TreeNodeUtil.generateTreeNodeOrNull(listOf(5, 3, 6, 2, 4, null, 7)),
                    key = 7,
                    result = TreeNodeUtil.generateTreeNodeOrNull(listOf(5, 3, 6, 2, 4)),
                ),
            )

        tests.forEach { test ->
            assertTrue { TreeNodeUtil.isEqual(sut.deleteNode(test.root, test.key), test.result) }
        }
    }
}
