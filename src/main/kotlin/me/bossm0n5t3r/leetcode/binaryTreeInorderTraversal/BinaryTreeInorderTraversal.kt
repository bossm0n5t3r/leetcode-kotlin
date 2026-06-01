package me.bossm0n5t3r.leetcode.binaryTreeInorderTraversal

import java.util.Stack
import me.bossm0n5t3r.leetcode.utils.TreeNode

class BinaryTreeInorderTraversal {
    class Solution {
        fun inorderTraversalRecursiveApproach(root: TreeNode?): List<Int> {
            val result = mutableListOf<Int>()
            return inorder(root, result)
        }

        private fun inorder(root: TreeNode?, result: MutableList<Int>): List<Int> {
            if (root != null) {
                inorder(root.left, result)
                result.add(root.`val`)
                inorder(root.right, result)
            }
            return result
        }

        fun inorderTraversalIteratingMethodUsingStack(root: TreeNode?): List<Int> {
            val result = mutableListOf<Int>()
            val stack = Stack<TreeNode>()
            var cur = root
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur)
                    cur = cur.left
                }
                cur = stack.pop()
                result.add(cur.`val`)
                cur = cur.right
            }
            return result
        }

        fun inorderTraversalMorrisTraversal(root: TreeNode?): List<Int> {
            val result = mutableListOf<Int>()
            var cur = root
            while (cur != null) {
                if (cur.left == null) {
                    result.add(cur.`val`)
                    cur = cur.right // move to next right node
                } else { // has a left subtree
                    var pre = cur.left
                    while (pre?.right != null) { // find rightmost
                        pre = pre.right
                    }
                    pre?.right = cur // put cur after the pre node
                    val tmp = cur // store cur node
                    cur = cur.left // move cur to the top of the new tree
                    tmp.left = null // original cur left be null, avoid infinite loops
                }
            }
            return result
        }
    }
}
