package me.bossm0n5t3r.leetcode.linkedListInBinaryTree

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.TreeNode

class LinkedListInBinaryTree {
    class Solution {
        fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
            if (root == null) return false
            return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right)
        }

        private fun dfs(head: ListNode?, root: TreeNode?): Boolean {
            if (head == null) return true
            if (root == null) return false
            if (head.`val` != root.`val`) return false
            return dfs(head.next, root.left) || dfs(head.next, root.right)
        }
    }
}
