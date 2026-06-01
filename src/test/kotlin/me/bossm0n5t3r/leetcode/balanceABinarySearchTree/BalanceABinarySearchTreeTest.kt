package me.bossm0n5t3r.leetcode.balanceABinarySearchTree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BalanceABinarySearchTreeTest {
    private val sut = BalanceABinarySearchTree.Solution()

    private data class TestData(val root: TreeNode?, val result: TreeNode?)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(1, null, 2, null, 3, null, 4)),
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(2, 1, 3, null, null, null, 4)),
                ),
                TestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(2, 1, 3)),
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(2, 1, 3)),
                ),
            )

        tests.forEach { test ->
            assertTrue { TreeNodeUtil.isEqual(sut.balanceBST(test.root), test.result) }
        }
    }
}
