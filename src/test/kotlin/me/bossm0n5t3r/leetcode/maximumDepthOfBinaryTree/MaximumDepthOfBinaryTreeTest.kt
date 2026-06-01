package me.bossm0n5t3r.leetcode.maximumDepthOfBinaryTree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MaximumDepthOfBinaryTreeTest {
    private val maximumDepthOfBinaryTree = MaximumDepthOfBinaryTree.Solution()

    data class MaximumDepthOfBinaryTreeTestData(val root: TreeNode?, val result: Int)

    @Test
    fun maxDepth() {
        val tests =
            listOf(
                MaximumDepthOfBinaryTreeTestData(
                    root = TreeNodeUtil.generateTreeNodeOrNull(listOf(3, 9, 20, null, null, 15, 7)),
                    result = 3,
                ),
                MaximumDepthOfBinaryTreeTestData(
                    root = TreeNodeUtil.generateTreeNodeOrNull(listOf(1, null, 2)),
                    result = 2,
                ),
                MaximumDepthOfBinaryTreeTestData(
                    root = TreeNodeUtil.generateTreeNodeOrNull(listOf()),
                    result = 0,
                ),
                MaximumDepthOfBinaryTreeTestData(
                    root = TreeNodeUtil.generateTreeNodeOrNull(listOf(0)),
                    result = 1,
                ),
            )
        tests.forEach { test ->
            assertTrue(maximumDepthOfBinaryTree.maxDepth(test.root) == test.result)
            assertTrue(maximumDepthOfBinaryTree.maxDepthAt230720(test.root) == test.result)
        }
    }
}
