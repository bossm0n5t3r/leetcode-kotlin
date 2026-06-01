package me.bossm0n5t3r.leetcode.binaryTreeRightSideView

import java.util.LinkedList
import me.bossm0n5t3r.leetcode.utils.TreeNode

class BinaryTreeRightSideView {
    class Solution {
        fun rightSideView(root: TreeNode?): List<Int> {
            if (root == null) return emptyList()
            val queue = LinkedList<TreeNode>().apply { this.add(root) }
            val result = mutableListOf<Int>()
            while (queue.isNotEmpty()) {
                val size = queue.size
                result.add(queue.last().`val`)
                repeat(size) {
                    val cur = queue.poll()
                    val curLeft = cur.left
                    val curRight = cur.right
                    if (curLeft != null) {
                        queue.add(curLeft)
                    }
                    if (curRight != null) {
                        queue.add(curRight)
                    }
                }
            }
            return result
        }
    }
}
