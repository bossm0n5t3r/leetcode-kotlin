package me.bossm0n5t3r.leetcode.binarySearchTreeToGreaterSumTree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BinarySearchTreeToGreaterSumTreeTest {
    private val sut = BinarySearchTreeToGreaterSumTree.Solution()

    private data class TestData(val root: TreeNode?, val result: TreeNode?)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    TreeNodeUtil.generateTreeNodeOrNull(
                        listOf(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8)
                    ),
                    TreeNodeUtil.generateTreeNodeOrNull(
                        listOf(
                            30,
                            36,
                            21,
                            36,
                            35,
                            26,
                            15,
                            null,
                            null,
                            null,
                            33,
                            null,
                            null,
                            null,
                            8,
                        )
                    ),
                ),
                TestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(0, null, 1)),
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(1, null, 1)),
                ),
            )

        tests.forEach { test ->
            assertTrue { TreeNodeUtil.isEqual(sut.bstToGst(test.root), test.result) }
        }
    }
}
