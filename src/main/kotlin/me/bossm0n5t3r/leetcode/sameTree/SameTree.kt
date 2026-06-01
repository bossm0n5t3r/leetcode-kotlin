package me.bossm0n5t3r.leetcode.sameTree

import java.util.LinkedList
import me.bossm0n5t3r.leetcode.utils.TreeNode

class SameTree {
    class Solution {
        fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
            if (p == null && q == null) return true
            if (p == null || q == null) return false
            val pTreeNodeQueue = LinkedList<TreeNode>().apply { this.add(p) }
            val qTreeNodeQueue = LinkedList<TreeNode>().apply { this.add(q) }
            while (pTreeNodeQueue.isNotEmpty() && qTreeNodeQueue.isNotEmpty()) {
                val pTreeNode = pTreeNodeQueue.poll()
                val qTreeNode = qTreeNodeQueue.poll()
                if (pTreeNode.`val` != qTreeNode.`val`) return false
                if (pTreeNode.left == null && qTreeNode.left != null) return false
                if (pTreeNode.left != null && qTreeNode.left == null) return false
                if (pTreeNode.right == null && qTreeNode.right != null) return false
                if (pTreeNode.right != null && qTreeNode.right == null) return false
                if (pTreeNode.left != null) {
                    pTreeNodeQueue.offer(pTreeNode.left)
                    qTreeNodeQueue.offer(qTreeNode.left)
                }
                if (pTreeNode.right != null) {
                    pTreeNodeQueue.offer(pTreeNode.right)
                    qTreeNodeQueue.offer(qTreeNode.right)
                }
            }
            return pTreeNodeQueue.isEmpty() && qTreeNodeQueue.isEmpty()
        }
    }
}
