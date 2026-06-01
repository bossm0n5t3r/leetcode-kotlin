package me.bossm0n5t3r.leetcode.findBottomLeftTreeValue

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindBottomLeftTreeValueTest {
    private val sut = FindBottomLeftTreeValue.Solution()

    private data class TestData(val root: TreeNode?, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(TreeNodeUtil.generateTreeNodeOrNull(listOf(2, 1, 3)), 1),
                TestData(
                    TreeNodeUtil.generateTreeNodeOrNull(
                        listOf(1, 2, 3, 4, null, 5, 6, null, null, 7)
                    ),
                    7,
                ),
            )

        tests.forEach { test -> assertEquals(test.result, sut.findBottomLeftValue(test.root)) }
    }
}
