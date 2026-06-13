package me.bossm0n5t3r.leetcode.binaryTreeInorderTraversal

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BinaryTreeInorderTraversalTest {
    private val binaryTreeInorderTraversal = BinaryTreeInorderTraversal.Solution()

    data class BinaryTreeInorderTraversalTestData(val root: TreeNode?, val result: List<Int>)

    @Test
    fun inorderTraversal() {
        val tests =
            listOf(
                BinaryTreeInorderTraversalTestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(1, null, 2, 3)),
                    listOf(1, 3, 2),
                ),
                BinaryTreeInorderTraversalTestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf()),
                    listOf(),
                ),
                BinaryTreeInorderTraversalTestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(1)),
                    listOf(1),
                ),
            )
        tests.forEach { test ->
            // RecursiveApproach
            val resultRecursiveApproach =
                binaryTreeInorderTraversal.inorderTraversalRecursiveApproach(test.root)
            assertTrue(resultRecursiveApproach.containsAll(test.result))
            assertEquals(test.result.size, resultRecursiveApproach.size)

            // Iterating Method Using Stack
            val resultIteratingMethodUsingStack =
                binaryTreeInorderTraversal.inorderTraversalIteratingMethodUsingStack(test.root)
            assertTrue(resultIteratingMethodUsingStack.containsAll(test.result))
            assertEquals(test.result.size, resultIteratingMethodUsingStack.size)

            // Morris Traversal
            val resultMorrisTraversal =
                binaryTreeInorderTraversal.inorderTraversalMorrisTraversal(test.root)
            assertTrue(resultMorrisTraversal.containsAll(test.result))
            assertEquals(test.result.size, resultMorrisTraversal.size)
        }
    }
}
