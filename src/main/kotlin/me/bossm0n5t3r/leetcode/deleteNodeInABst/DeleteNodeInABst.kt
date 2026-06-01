package me.bossm0n5t3r.leetcode.deleteNodeInABst

import me.bossm0n5t3r.leetcode.utils.TreeNode

class DeleteNodeInABst {
    class Solution {
        private fun inorderSuccessor(root: TreeNode?): TreeNode? =
            if (root?.left == null) {
                root
            } else {
                inorderSuccessor(root.left)
            }

        @Suppress("ReturnCount")
        fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
            if (root == null) return null

            if (root.`val` > key) {
                root.left = deleteNode(root.left, key)
            } else if (root.`val` < key) {
                root.right = deleteNode(root.right, key)
            } else {
                if (root.left == null && root.right == null) {
                    return null
                } else if (root.left == null) {
                    return root.right
                } else if (root.right == null) {
                    return root.left
                } else {
                    val inorderSuccessor = inorderSuccessor(root.right)
                    root.`val` = inorderSuccessor?.`val`!!
                    root.right = deleteNode(root.right, inorderSuccessor.`val`)
                }
            }
            return root
        }
    }
}
