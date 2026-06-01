package me.bossm0n5t3r.leetcode.countGoodNodesInBinaryTree

import java.util.Stack
import me.bossm0n5t3r.leetcode.utils.TreeNode

class CountGoodNodesInBinaryTree {
    class Solution {
        fun goodNodes(root: TreeNode?): Int {
            if (root == null) return 0
            val stack = Stack<Pair<TreeNode, Int>>().also { it.push(root to root.`val`) }
            var result = 0
            while (stack.isNotEmpty()) {
                val (cur, maxOfPath) = stack.pop()
                val curLeft = cur.left
                val curRight = cur.right
                if (cur.`val` >= maxOfPath) {
                    result++
                }
                if (curLeft != null) {
                    stack.push(curLeft to maxOf(maxOfPath, curLeft.`val`))
                }
                if (curRight != null) {
                    stack.push(curRight to maxOf(maxOfPath, curRight.`val`))
                }
            }
            return result
        }
    }
}
