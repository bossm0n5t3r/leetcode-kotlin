package me.bossm0n5t3r.leetcode.binaryTreeRightSideView

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreeRightSideViewTest {
    private val sut = BinaryTreeRightSideView.Solution()

    private data class TestData(val root: TreeNode?, val result: List<Int>)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    root = TreeNodeUtil.generateTreeNodeOrNull(listOf(1, 2, 3, null, 5, null, 4)),
                    result = listOf(1, 3, 4),
                ),
                TestData(
                    root = TreeNodeUtil.generateTreeNodeOrNull(listOf(1, null, 3)),
                    result = listOf(1, 3),
                ),
                TestData(root = TreeNodeUtil.generateTreeNodeOrNull(listOf()), result = listOf()),
            )

        tests.forEach { test -> assertEquals(test.result, sut.rightSideView(test.root)) }
    }
}
