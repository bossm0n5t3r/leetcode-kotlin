package me.bossm0n5t3r.leetcode.balancedbinarytree

import me.bossm0n5t3r.leetcode.utils.TreeNode

class BalancedBinaryTree {
    class Solution {
        fun isBalanced(root: TreeNode?): Boolean {
            if (root == null) return true
            val leftHeight = root.left?.getHeight() ?: 0
            val rightHeight = root.right?.getHeight() ?: 0
            return abs(leftHeight - rightHeight) <= 1 &&
                isBalanced(root.left) &&
                isBalanced(root.right)
        }

        private fun TreeNode.getHeight(): Int {
            if (this.left == null && this.right == null) return 1
            return maxOf(this.left?.getHeight() ?: 0, this.right?.getHeight() ?: 0) + 1
        }

        private fun abs(x: Int): Int = if (x >= 0) x else -x
    }
}
