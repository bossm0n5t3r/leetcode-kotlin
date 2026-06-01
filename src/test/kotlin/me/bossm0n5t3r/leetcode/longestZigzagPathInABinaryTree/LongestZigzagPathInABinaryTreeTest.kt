package me.bossm0n5t3r.leetcode.longestZigzagPathInABinaryTree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestZigzagPathInABinaryTreeTest {
    private val sut = LongestZigzagPathInABinaryTree.Solution()

    private data class TestData(val root: TreeNode?, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    root =
                        TreeNodeUtil.generateTreeNodeOrNull(
                            listOf(1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1)
                        ),
                    result = 3,
                ),
                TestData(
                    root =
                        TreeNodeUtil.generateTreeNodeOrNull(
                            listOf(1, 1, 1, null, 1, null, null, 1, 1, null, 1)
                        ),
                    result = 4,
                ),
                TestData(root = TreeNodeUtil.generateTreeNodeOrNull(listOf(1)), result = 0),
            )

        tests.forEach { test -> assertEquals(sut.longestZigZag(test.root), test.result) }
    }
}
