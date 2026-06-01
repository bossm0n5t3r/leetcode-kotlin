package me.bossm0n5t3r.leetcode.sameTree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SameTreeTest {
    private val sut = SameTree.Solution()

    private data class TestData(val p: TreeNode?, val q: TreeNode?, val result: Boolean)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(1, 2, 3)),
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(1, 2, 3)),
                    true,
                ),
                TestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(1, 2)),
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(1, null, 2)),
                    false,
                ),
                TestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(1, 2, 1)),
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(1, 1, 2)),
                    false,
                ),
            )

        tests.forEach { test -> assertEquals(test.result, sut.isSameTree(test.p, test.q)) }
    }
}
