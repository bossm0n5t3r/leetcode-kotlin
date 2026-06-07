package me.bossm0n5t3r.leetcode.createbinarytreefromdescriptions

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CreateBinaryTreeFromDescriptionsTest {
    private val sut = CreateBinaryTreeFromDescriptions.Solution()

    private data class TestData(val description: Array<IntArray>, val result: TreeNode?) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!description.contentDeepEquals(other.description)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = description.contentDeepHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    arrayOf(
                        intArrayOf(20, 15, 1),
                        intArrayOf(20, 17, 0),
                        intArrayOf(50, 20, 1),
                        intArrayOf(50, 80, 0),
                        intArrayOf(80, 19, 1),
                    ),
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(50, 20, 80, 15, 17, 19)),
                ),
                TestData(
                    arrayOf(intArrayOf(1, 2, 1), intArrayOf(2, 3, 0), intArrayOf(3, 4, 1)),
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(1, 2, null, null, 3, 4)),
                ),
            )

        for (testData in testDataList) {
            assertTrue {
                TreeNodeUtil.isEqual(sut.createBinaryTree(testData.description), testData.result)
            }
        }
    }
}
