package me.bossm0n5t3r.leetcode.lowestCommonAncestorOfABinaryTree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LowestCommonAncestorOfABinaryTreeTest {
    private val sut = LowestCommonAncestorOfABinaryTree.Solution()

    private data class TestData(
        val root: TreeNode?,
        val p: TreeNode?,
        val q: TreeNode?,
        val result: TreeNode?,
    )

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    root =
                        TreeNodeUtil.generateTreeNodeOrNull(
                            listOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
                        ),
                    p = TreeNode(5),
                    q = TreeNode(1),
                    result = TreeNode(3),
                ),
                TestData(
                    root =
                        TreeNodeUtil.generateTreeNodeOrNull(
                            listOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
                        ),
                    p = TreeNode(5),
                    q = TreeNode(4),
                    result = TreeNode(5),
                ),
                TestData(
                    root = TreeNodeUtil.generateTreeNodeOrNull(listOf(1, 2)),
                    p = TreeNode(1),
                    q = TreeNode(2),
                    result = TreeNode(1),
                ),
            )

        tests.forEach { test ->
            assertEquals(
                sut.lowestCommonAncestor(root = test.root, p = test.p, q = test.q)?.`val`,
                test.result?.`val`,
            )
        }
    }
}
