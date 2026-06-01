package me.bossm0n5t3r.leetcode.lowestCommonAncestorOfABinaryTree

import java.util.Stack
import me.bossm0n5t3r.leetcode.utils.TreeNode

class LowestCommonAncestorOfABinaryTree {
    class Solution {
        fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
            if (root == null) return null
            var pAncestors = emptySet<Int>()
            var qAncestors = emptySet<Int>()
            val stack =
                Stack<Pair<TreeNode, Set<Int>>>().apply { this.push(root to setOf(root.`val`)) }
            while (stack.isNotEmpty()) {
                val (cur, ancestors) = stack.pop()
                if (cur.`val` == p?.`val`) {
                    pAncestors = ancestors
                }
                if (cur.`val` == q?.`val`) {
                    qAncestors = ancestors
                }
                val curLeft = cur.left
                val curRight = cur.right
                if (curLeft != null) {
                    stack.push(curLeft to ancestors + curLeft.`val`)
                }
                if (curRight != null) {
                    stack.push(curRight to ancestors + curRight.`val`)
                }
            }
            return TreeNode(pAncestors.intersect(qAncestors).last())
        }
    }
}
