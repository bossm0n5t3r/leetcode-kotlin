package me.bossm0n5t3r.leetcode.maximumLevelSumOfABinaryTree

import java.util.LinkedList
import me.bossm0n5t3r.leetcode.utils.TreeNode

class MaximumLevelSumOfABinaryTree {
    class Solution {
        fun maxLevelSum(root: TreeNode?): Int {
            if (root == null) return 0
            var level = 0
            var smallestLevel = Int.MAX_VALUE
            var maximalSum = Int.MIN_VALUE
            val queue = LinkedList<TreeNode>().apply { this.add(root) }
            while (queue.isNotEmpty()) {
                val size = queue.size
                var tmp = 0
                level++
                repeat(size) {
                    val cur = queue.poll()
                    tmp += cur.`val`
                    val curLeft = cur.left
                    val curRight = cur.right
                    if (curLeft != null) {
                        queue.add(curLeft)
                    }
                    if (curRight != null) {
                        queue.add(curRight)
                    }
                }
                if (tmp > maximalSum) {
                    maximalSum = tmp
                    smallestLevel = level
                }
            }
            return smallestLevel
        }
    }
}
