package me.bossm0n5t3r.leetcode.minimumDepthOfBinaryTree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MinimumDepthOfBinaryTreeTest {
    private val minimumDepthOfBinaryTree = MinimumDepthOfBinaryTree.Solution()

    private data class MinimumDepthOfBinaryTreeTestData(val root: TreeNode?, val result: Int)

    @Test
    fun minDepth() {
        val tests =
            listOf(
                MinimumDepthOfBinaryTreeTestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(3, 9, 20, null, null, 15, 7)),
                    2,
                ),
                MinimumDepthOfBinaryTreeTestData(
                    TreeNodeUtil.generateTreeNodeOrNull(
                        listOf(2, null, 3, null, 4, null, 5, null, 6)
                    ),
                    5,
                ),
            )
        tests.forEach { test ->
            minimumDepthOfBinaryTree.minDepth(test.root).also {
                println(it)
                assertEquals(it, test.result)
            }
        }
    }
}
