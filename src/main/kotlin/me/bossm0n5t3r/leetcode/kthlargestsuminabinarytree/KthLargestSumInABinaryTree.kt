package me.bossm0n5t3r.leetcode.kthlargestsuminabinarytree

import java.util.LinkedList
import java.util.Queue
import me.bossm0n5t3r.leetcode.utils.TreeNode

class KthLargestSumInABinaryTree {
    class Solution {
        fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {
            if (root == null) return -1
            val levelSumList = mutableListOf<Long>()
            val queue = LinkedList<TreeNode>() as Queue<TreeNode>
            queue.offer(root)
            while (queue.isNotEmpty()) {
                var size = queue.size
                var tmp = 0L
                while (size-- > 0) {
                    val cur = queue.poll()
                    tmp += cur.`val`
                    if (cur.left != null) {
                        queue.offer(cur.left)
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right)
                    }
                }
                levelSumList.add(tmp)
            }
            return levelSumList.sortedDescending().getOrNull(k - 1) ?: -1L
        }
    }
}
