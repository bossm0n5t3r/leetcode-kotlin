package me.bossm0n5t3r.leetcode.diameterOfBinaryTree

import me.bossm0n5t3r.leetcode.utils.TreeNode

class DiameterOfBinaryTree {
    class Solution {
        fun diameterOfBinaryTree(root: TreeNode?): Int {
            val result = IntArray(1) { 0 }
            dfs(root, result)
            return result[0]
        }

        private fun dfs(node: TreeNode?, result: IntArray): Int {
            if (node == null) return 0
            val l = dfs(node.left, result)
            val r = dfs(node.right, result)
            result[0] = maxOf(result[0], l + r)
            return maxOf(l, r) + 1
        }
    }
}
