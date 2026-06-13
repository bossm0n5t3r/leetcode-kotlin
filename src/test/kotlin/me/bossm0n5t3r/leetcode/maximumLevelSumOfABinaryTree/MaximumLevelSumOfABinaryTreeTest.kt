package me.bossm0n5t3r.leetcode.maximumLevelSumOfABinaryTree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumLevelSumOfABinaryTreeTest {
    private val sut = MaximumLevelSumOfABinaryTree.Solution()

    private data class TestData(val root: TreeNode?, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    root = TreeNodeUtil.generateTreeNodeOrNull(listOf(1, 7, 0, 7, -8, null, null)),
                    result = 2,
                ),
                TestData(
                    root =
                        TreeNodeUtil.generateTreeNodeOrNull(
                            listOf(989, null, 10250, 98693, -89388, null, null, null, -32127)
                        ),
                    result = 2,
                ),
            )

        tests.forEach { test -> assertEquals(test.result, sut.maxLevelSum(test.root)) }
    }
}
