package me.bossm0n5t3r.leetcode.leafSimilarTrees

import java.util.Stack
import me.bossm0n5t3r.leetcode.utils.TreeNode

class LeafSimilarTrees {
    class Solution {
        fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean =
            getLeafValueSequence(root1) == getLeafValueSequence(root2)

        private fun getLeafValueSequence(root: TreeNode?): List<Int> {
            if (root == null) return emptyList()
            val result = mutableListOf<Int>()
            val stack = Stack<TreeNode>().also { it.push(root) }
            while (stack.isNotEmpty()) {
                val cur = stack.pop()
                val curLeft = cur.left
                val curRight = cur.right
                if (curLeft == null && curRight == null) {
                    result.add(cur.`val`)
                    continue
                }
                if (curLeft != null) {
                    stack.push(curLeft)
                }
                if (curRight != null) {
                    stack.push(curRight)
                }
            }
            return result
        }
    }
}
