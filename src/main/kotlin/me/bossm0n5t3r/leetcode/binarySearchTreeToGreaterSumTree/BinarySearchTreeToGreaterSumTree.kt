package me.bossm0n5t3r.leetcode.binarySearchTreeToGreaterSumTree

import me.bossm0n5t3r.leetcode.utils.TreeNode

class BinarySearchTreeToGreaterSumTree {
    class Solution {
        fun bstToGst(root: TreeNode?): TreeNode? {
            val max = IntArray(1)
            return dfs(root, max)
        }

        private fun dfs(root: TreeNode?, sum: IntArray): TreeNode? {
            if (root == null) return null
            dfs(root.right, sum)
            sum[0] += root.`val`
            root.`val` = sum[0]
            dfs(root.left, sum)
            return root
        }
    }
}
