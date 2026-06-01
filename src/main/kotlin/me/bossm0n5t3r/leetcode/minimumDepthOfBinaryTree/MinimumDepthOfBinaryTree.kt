package me.bossm0n5t3r.leetcode.minimumDepthOfBinaryTree

import java.util.LinkedList
import me.bossm0n5t3r.leetcode.utils.TreeNode

class MinimumDepthOfBinaryTree {
    class Solution {
        fun minDepth(root: TreeNode?): Int {
            if (root == null) return 0
            var minimumDepth = 0
            val queue = LinkedList<TreeNode?>()
            queue.add(root)
            while (queue.isNotEmpty()) {
                val size = queue.size
                minimumDepth++
                repeat(size) {
                    val cur = queue.poll()
                    if (cur?.left == null && cur?.right == null) return minimumDepth
                    cur.left?.let { queue.add(it) }
                    cur.right?.let { queue.add(it) }
                }
            }
            return minimumDepth
        }
    }
}
