package me.bossm0n5t3r.leetcode.createbinarytreefromdescriptions

import me.bossm0n5t3r.leetcode.utils.TreeNode

class CreateBinaryTreeFromDescriptions {
    class Solution {
        fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
            val nodeMap = mutableMapOf<Int, TreeNode>()
            val children = mutableSetOf<Int>()

            for (description in descriptions) {
                val (parent, child, isLeft) = description
                val parentNode = nodeMap.getOrPut(parent) { TreeNode(parent) }
                val childNode = nodeMap.getOrPut(child) { TreeNode(child) }

                if (isLeft == 1) {
                    parentNode.left = childNode
                } else {
                    parentNode.right = childNode
                }

                children.add(child)
            }

            return nodeMap.values.first { it.`val` !in children }
        }
    }
}
