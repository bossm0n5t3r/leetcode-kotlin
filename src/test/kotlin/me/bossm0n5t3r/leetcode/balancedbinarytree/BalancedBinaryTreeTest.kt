package me.bossm0n5t3r.leetcode.balancedbinarytree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BalancedBinaryTreeTest {
    private val sut = BalancedBinaryTree.Solution()

    private data class TestData(val root: TreeNode?, val result: Boolean)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(3, 9, 20, null, null, 15, 7)),
                    true,
                ),
                TestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(1, 2, 2, 3, 3, null, null, 4, 4)),
                    false,
                ),
                TestData(TreeNodeUtil.generateTreeNodeOrNull(emptyList()), true),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.isBalanced(testData.root))
        }
    }
}
