package me.bossm0n5t3r.leetcode.flipequivalentbinarytrees

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FlipEquivalentBinaryTreesTest {
    private val sut = FlipEquivalentBinaryTrees.Solution()

    private data class TestData(val root1: TreeNode?, val root2: TreeNode?, val result: Boolean)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    TreeNodeUtil.generateTreeNodeOrNull(
                        listOf(1, 2, 3, 4, 5, 6, null, null, null, 7, 8)
                    ),
                    TreeNodeUtil.generateTreeNodeOrNull(
                        listOf(1, 3, 2, null, 6, 4, 5, null, null, null, null, 8, 7)
                    ),
                    true,
                ),
                TestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf()),
                    TreeNodeUtil.generateTreeNodeOrNull(listOf()),
                    true,
                ),
                TestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf()),
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(1)),
                    false,
                ),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.flipEquiv(testData.root1, testData.root2))
        }
    }
}
