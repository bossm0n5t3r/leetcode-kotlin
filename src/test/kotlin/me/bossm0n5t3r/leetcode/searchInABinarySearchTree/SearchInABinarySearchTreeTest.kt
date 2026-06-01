package me.bossm0n5t3r.leetcode.searchInABinarySearchTree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SearchInABinarySearchTreeTest {
    private val sut = SearchInABinarySearchTree.Solution()

    private data class TestData(val root: TreeNode?, val `val`: Int, val result: TreeNode?)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    root = TreeNodeUtil.generateTreeNodeOrNull(listOf(4, 2, 7, 1, 3)),
                    `val` = 2,
                    result = TreeNodeUtil.generateTreeNodeOrNull(listOf(2, 1, 3)),
                ),
                TestData(
                    root = TreeNodeUtil.generateTreeNodeOrNull(listOf(4, 2, 7, 1, 3)),
                    `val` = 5,
                    result = TreeNodeUtil.generateTreeNodeOrNull(listOf()),
                ),
            )

        tests.forEach { test ->
            assertTrue { TreeNodeUtil.isEqual(sut.searchBST(test.root, test.`val`), test.result) }
        }
    }
}
