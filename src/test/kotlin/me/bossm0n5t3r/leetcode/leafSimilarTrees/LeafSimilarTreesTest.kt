package me.bossm0n5t3r.leetcode.leafSimilarTrees

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LeafSimilarTreesTest {
    private val sut = LeafSimilarTrees.Solution()

    private data class TestData(val root1: TreeNode?, val root2: TreeNode?, val result: Boolean)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    root1 =
                        TreeNodeUtil.generateTreeNodeOrNull(
                            listOf(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4)
                        ),
                    root2 =
                        TreeNodeUtil.generateTreeNodeOrNull(
                            listOf(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8)
                        ),
                    result = true,
                ),
                TestData(
                    root1 = TreeNodeUtil.generateTreeNodeOrNull(listOf(1, 2, 3)),
                    root2 = TreeNodeUtil.generateTreeNodeOrNull(listOf(1, 3, 2)),
                    result = false,
                ),
            )

        tests.forEach { test -> assertEquals(sut.leafSimilar(test.root1, test.root2), test.result) }
    }
}
