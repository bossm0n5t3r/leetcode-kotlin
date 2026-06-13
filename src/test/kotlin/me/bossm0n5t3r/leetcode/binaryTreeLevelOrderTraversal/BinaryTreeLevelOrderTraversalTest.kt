package me.bossm0n5t3r.leetcode.binaryTreeLevelOrderTraversal

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreeLevelOrderTraversalTest {
    private val binaryTreeLevelOrderTraversal = BinaryTreeLevelOrderTraversal.Solution()

    data class BinaryTreeLevelOrderTraversalTestData(
        val root: TreeNode?,
        val result: List<List<Int>>,
    )

    @Test
    fun levelOrder() {
        val tests =
            listOf(
                BinaryTreeLevelOrderTraversalTestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(3, 9, 20, null, null, 15, 7)),
                    listOf(listOf(3), listOf(9, 20), listOf(15, 7)),
                ),
                BinaryTreeLevelOrderTraversalTestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(1)),
                    listOf(listOf(1)),
                ),
                BinaryTreeLevelOrderTraversalTestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf()),
                    listOf(),
                ),
            )
        tests.forEach { test ->
            assertEquals(test.result, binaryTreeLevelOrderTraversal.levelOrder(test.root))
        }
    }
}
