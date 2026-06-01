package me.bossm0n5t3r.leetcode.maximumDepthOfBinaryTree

import java.util.LinkedList
import java.util.Queue
import java.util.Stack
import me.bossm0n5t3r.leetcode.utils.TreeNode

class MaximumDepthOfBinaryTree {
    class Solution {
        fun maxDepth(root: TreeNode?): Int {
            if (root == null) return 0
            val q: Queue<TreeNode> = LinkedList()
            q.add(root)
            var height = 0
            var cur: TreeNode
            var size: Int
            while (q.isNotEmpty()) {
                height++
                size = q.size
                for (i in 0 until size) {
                    cur = q.poll()
                    if (cur.left != null) {
                        q.add(cur.left)
                    }
                    if (cur.right != null) {
                        q.add(cur.right)
                    }
                }
            }
            return height
        }

        fun maxDepthAt230720(root: TreeNode?): Int {
            if (root == null) return 0
            val stack = Stack<Pair<TreeNode, Int>>().also { it.push(root to 1) }
            var result = 0
            while (stack.isNotEmpty()) {
                val (cur, depth) = stack.pop()
                val curLeft = cur.left
                val curRight = cur.right
                if (curLeft == null && curRight == null) {
                    result = maxOf(result, depth)
                    continue
                }
                if (curLeft != null) {
                    stack.push(curLeft to (depth + 1))
                }
                if (curRight != null) {
                    stack.push(curRight to (depth + 1))
                }
            }
            return result
        }
    }
}
