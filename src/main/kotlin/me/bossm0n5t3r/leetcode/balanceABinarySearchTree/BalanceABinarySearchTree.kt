package me.bossm0n5t3r.leetcode.balanceABinarySearchTree

import me.bossm0n5t3r.leetcode.utils.TreeNode

class BalanceABinarySearchTree {
    class Solution {
        fun balanceBST(root: TreeNode?): TreeNode? {
            if (root == null) return null
            val result = mutableListOf<Int>()
            getAllNodesFromRootInOrderTraversal(root, result)
            return generateBalanceBST(0, result.size - 1, result)
        }

        private fun getAllNodesFromRootInOrderTraversal(root: TreeNode?, result: MutableList<Int>) {
            if (root == null) return
            getAllNodesFromRootInOrderTraversal(root.left, result)
            result.add(root.`val`)
            getAllNodesFromRootInOrderTraversal(root.right, result)
        }

        private fun generateBalanceBST(start: Int, end: Int, allNodeList: List<Int>): TreeNode? {
            if (start > end) return null
            if (start == end) return TreeNode(allNodeList[start])
            val mid = (start + end) / 2
            val root = TreeNode(allNodeList[mid])
            root.left = generateBalanceBST(start, mid - 1, allNodeList)
            root.right = generateBalanceBST(mid + 1, end, allNodeList)
            return root
        }
    }
}
