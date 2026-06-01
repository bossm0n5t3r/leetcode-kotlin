package me.bossm0n5t3r.leetcode.numberOfGoodLeafNodesPairs

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfGoodLeafNodesPairsTest {
    private val sut = NumberOfGoodLeafNodesPairs.Solution()

    private data class TestData(val root: TreeNode?, val distance: Int, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(TreeNodeUtil.generateTreeNodeOrNull(listOf(1, 2, 3, null, 4)), 3, 1),
                TestData(TreeNodeUtil.generateTreeNodeOrNull(listOf(1, 2, 3, 4, 5, 6, 7)), 3, 2),
                TestData(
                    TreeNodeUtil.generateTreeNodeOrNull(
                        listOf(7, 1, 4, 6, null, 5, 3, null, null, null, null, null, 2)
                    ),
                    3,
                    1,
                ),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.countPairs(test.root, test.distance))
        }
    }
}
