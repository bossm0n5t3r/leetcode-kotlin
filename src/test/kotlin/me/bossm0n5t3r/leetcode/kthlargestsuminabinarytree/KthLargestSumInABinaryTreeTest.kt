package me.bossm0n5t3r.leetcode.kthlargestsuminabinarytree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthLargestSumInABinaryTreeTest {
    private val sut = KthLargestSumInABinaryTree.Solution()

    private data class TestData(val root: TreeNode?, val k: Int, val result: Long)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(5, 8, 9, 2, 1, 3, 7, 4, 6)),
                    2,
                    13L,
                ),
                TestData(TreeNodeUtil.generateTreeNodeOrNull(listOf(1, 2, null, 3)), 1, 3L),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.kthLargestLevelSum(testData.root, testData.k))
        }
    }
}
