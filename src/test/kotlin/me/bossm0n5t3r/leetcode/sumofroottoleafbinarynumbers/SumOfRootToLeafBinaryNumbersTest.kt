package me.bossm0n5t3r.leetcode.sumofroottoleafbinarynumbers

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfRootToLeafBinaryNumbersTest {
    private val sut = SumOfRootToLeafBinaryNumbers.Solution()

    private data class TestData(val root: TreeNode?, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(TreeNodeUtil.generateTreeNodeOrNull(listOf(1, 0, 1, 0, 1, 0, 1)), 22),
                TestData(TreeNodeUtil.generateTreeNodeOrNull(listOf(0)), 0),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.sumRootToLeaf(testData.root))
        }
    }
}
