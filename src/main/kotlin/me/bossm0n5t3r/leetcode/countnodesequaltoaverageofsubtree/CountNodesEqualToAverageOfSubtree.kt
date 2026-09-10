package me.bossm0n5t3r.leetcode.countnodesequaltoaverageofsubtree

import me.bossm0n5t3r.leetcode.utils.TreeNode

class CountNodesEqualToAverageOfSubtree {
    class Solution {
        fun averageOfSubtree(root: TreeNode?): Int {
            val result = IntArray(1)
            dfs(root, result)
            return result[0]
        }

        private fun dfs(root: TreeNode?, result: IntArray): Pair<Int, Int> {
            if (root == null) return 0 to 0
            val (leftSum, leftCount) = dfs(root.left, result)
            val (rightSum, rightCount) = dfs(root.right, result)

            val curSum = root.`val` + leftSum + rightSum
            val curCount = 1 + leftCount + rightCount

            if (root.`val` == curSum / curCount) result[0]++

            return curSum to curCount
        }
    }
}
