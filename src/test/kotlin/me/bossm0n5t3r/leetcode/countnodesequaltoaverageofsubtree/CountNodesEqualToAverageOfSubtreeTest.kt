package me.bossm0n5t3r.leetcode.countnodesequaltoaverageofsubtree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNodesEqualToAverageOfSubtreeTest {
    private val sut = CountNodesEqualToAverageOfSubtree.Solution()

    private data class TestData(val root: TreeNode?, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(TreeNodeUtil.generateTreeNodeOrNull(listOf(4, 8, 5, 0, 1, null, 6)), 5),
                TestData(TreeNodeUtil.generateTreeNodeOrNull(listOf(1)), 1),
                TestData(null, 0),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.averageOfSubtree(testData.root))
        }
    }
}
