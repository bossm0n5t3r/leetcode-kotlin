package me.bossm0n5t3r.leetcode.distributeCoinsInBinaryTree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DistributeCoinsInBinaryTreeTest {
    private val distributeCoinsInBinaryTree = DistributeCoinsInBinaryTree.Solution()

    private data class DistributeCoinsInBinaryTreeTestData(val root: TreeNode?, val result: Int)

    @Test
    fun distributeCoins() {
        val tests =
            listOf(
                DistributeCoinsInBinaryTreeTestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(3, 0, 0)),
                    2,
                ),
                DistributeCoinsInBinaryTreeTestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(0, 3, 0)),
                    3,
                ),
            )
        tests.forEach { test ->
            distributeCoinsInBinaryTree.distributeCoins(test.root).also {
                assertEquals(test.result, it)
            }
        }
    }
}
