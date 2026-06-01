package me.bossm0n5t3r.leetcode.convertSortedArrayToBST

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ConvertSortedArrayToBSTTest {
    private val convertSortedArrayToBST = ConvertSortedArrayToBST.Solution()

    data class ConvertSortedArrayToBSTTestData(val nums: IntArray, val result: TreeNode?) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as ConvertSortedArrayToBSTTestData

            if (!nums.contentEquals(other.nums)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + (result?.hashCode() ?: 0)
            return result1
        }
    }

    @Test
    fun sortedArrayToBST() {
        val tests =
            listOf(
                ConvertSortedArrayToBSTTestData(
                    nums = intArrayOf(-10, -3, 0, 5, 9),
                    result = TreeNodeUtil.generateTreeNodeOrNull(listOf(0, -3, 9, -10, null, 5)),
                ),
                ConvertSortedArrayToBSTTestData(
                    nums = intArrayOf(1, 3),
                    result = TreeNodeUtil.generateTreeNodeOrNull(listOf(3, 1)),
                ),
            )
        tests.forEach { test ->
            assertTrue(
                TreeNodeUtil.isEqual(
                    convertSortedArrayToBST.sortedArrayToBST(test.nums),
                    test.result!!,
                )
            )
        }
    }
}
