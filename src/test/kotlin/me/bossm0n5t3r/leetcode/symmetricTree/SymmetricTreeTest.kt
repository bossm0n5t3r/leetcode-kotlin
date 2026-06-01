package me.bossm0n5t3r.leetcode.symmetricTree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SymmetricTreeTest {
    private val symmetricTree = SymmetricTree.Solution()

    data class SymmetricTreeTestData(val root: TreeNode?, val result: Boolean)

    @Test
    fun isSymmetric() {
        val tests =
            listOf(
                SymmetricTreeTestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(1, 2, 2, 3, 4, 4, 3)),
                    true,
                ),
                SymmetricTreeTestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(1, 2, 2, null, 3, null, 3)),
                    false,
                ),
            )
        tests.forEach { test -> assertEquals(symmetricTree.isSymmetric(test.root), test.result) }
    }
}
