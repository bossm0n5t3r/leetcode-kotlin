package me.bossm0n5t3r.leetcode.distributeCoinsInBinaryTree

import kotlin.math.abs
import me.bossm0n5t3r.leetcode.utils.TreeNode

class DistributeCoinsInBinaryTree {
    class Solution {
        fun distributeCoins(root: TreeNode?): Int {
            val result = IntWrapper()
            dfs(root, result)
            return result.value
        }

        private data class IntWrapper(var value: Int = 0)

        private fun dfs(node: TreeNode?, intWrapper: IntWrapper): Int {
            if (node == null) return 0
            val l = dfs(node.left, intWrapper)
            val r = dfs(node.right, intWrapper)
            intWrapper.value += abs(l) + abs(r)
            return node.`val` + l + r - 1
        }
    }
}
