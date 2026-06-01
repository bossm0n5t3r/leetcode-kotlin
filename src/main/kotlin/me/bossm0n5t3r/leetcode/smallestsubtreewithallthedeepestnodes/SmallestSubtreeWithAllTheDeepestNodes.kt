package me.bossm0n5t3r.leetcode.smallestsubtreewithallthedeepestnodes

import me.bossm0n5t3r.leetcode.utils.TreeNode

class SmallestSubtreeWithAllTheDeepestNodes {
    class Solution {
        fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
            if (root == null) return null
            if (root.left == null && root.right == null) return root
            val (leftSideLevel, leftSideNode) = deepestLeaves(root.left, 1)
            val (rightSideLevel, rightSideNode) = deepestLeaves(root.right, 1)
            return when {
                (leftSideLevel == rightSideLevel) -> root
                leftSideLevel > rightSideLevel -> leftSideNode
                else -> rightSideNode
            }
        }

        private fun deepestLeaves(root: TreeNode?, curLevel: Int): Pair<Int, TreeNode?> {
            if (root?.left == null && root?.right == null) return curLevel to root
            val (leftSideLevel, leftSideNode) = deepestLeaves(root.left, curLevel + 1)
            val (rightSideLevel, rightSideNode) = deepestLeaves(root.right, curLevel + 1)
            if (root.left == null) return rightSideLevel to rightSideNode
            if (root.right == null) return leftSideLevel to leftSideNode
            return when {
                leftSideLevel == rightSideLevel -> leftSideLevel to root
                leftSideLevel > rightSideLevel -> leftSideLevel to leftSideNode
                else -> rightSideLevel to rightSideNode
            }
        }
    }
}
