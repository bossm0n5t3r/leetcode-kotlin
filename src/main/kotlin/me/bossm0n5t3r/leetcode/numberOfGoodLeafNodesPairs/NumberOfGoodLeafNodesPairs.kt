package me.bossm0n5t3r.leetcode.numberOfGoodLeafNodesPairs

import me.bossm0n5t3r.leetcode.utils.TreeNode

class NumberOfGoodLeafNodesPairs {
    class Solution {
        fun countPairs(root: TreeNode?, distance: Int): Int {
            var count = 0

            fun dfs(node: TreeNode?): List<Int> {
                if (node == null) return emptyList()
                if (node.left == null && node.right == null) return listOf(1)
                val left = dfs(node.left)
                val right = dfs(node.right)
                for (l in left) {
                    for (r in right) {
                        if (l + r <= distance) count++
                    }
                }
                return (left + right).map { it + 1 }.filter { it <= distance }
            }

            dfs(root)
            return count
        }
    }
}
