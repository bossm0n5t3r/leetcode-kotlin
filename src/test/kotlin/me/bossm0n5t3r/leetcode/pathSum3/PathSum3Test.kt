package me.bossm0n5t3r.leetcode.pathSum3

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PathSum3Test {
    private val sut = PathSum3.Solution()

    private data class TestData(val root: TreeNode?, val targetSum: Int, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    root =
                        TreeNodeUtil.generateTreeNodeOrNull(
                            listOf(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1)
                        ),
                    targetSum = 8,
                    result = 3,
                ),
                TestData(
                    root =
                        TreeNodeUtil.generateTreeNodeOrNull(
                            listOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1)
                        ),
                    targetSum = 22,
                    result = 3,
                ),
                TestData(
                    root = TreeNodeUtil.generateTreeNodeOrNull(listOf(0, 1, 1)),
                    targetSum = 1,
                    result = 4,
                ),
                TestData(
                    root =
                        TreeNodeUtil.generateTreeNodeOrNull(
                            listOf(
                                1000000000,
                                1000000000,
                                null,
                                294967296,
                                null,
                                1000000000,
                                null,
                                1000000000,
                                null,
                                1000000000,
                            )
                        ),
                    targetSum = 0,
                    result = 0,
                ),
            )

        tests.forEach { test -> assertEquals(sut.pathSum(test.root, test.targetSum), test.result) }
    }
}
