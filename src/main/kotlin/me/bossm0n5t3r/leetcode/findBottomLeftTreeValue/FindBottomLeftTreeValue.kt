package me.bossm0n5t3r.leetcode.findBottomLeftTreeValue

import java.util.LinkedList
import me.bossm0n5t3r.leetcode.utils.TreeNode

class FindBottomLeftTreeValue {
    class Solution {
        fun findBottomLeftValue(root: TreeNode?): Int {
            if (root == null) return -1
            val treeNodeQueue = LinkedList<TreeNode>().apply { this.add(root) }
            val rowList = mutableListOf<MutableList<Int>>()
            while (treeNodeQueue.isNotEmpty()) {
                val currentRow = mutableListOf<Int>()
                val size = treeNodeQueue.size
                repeat(size) {
                    val node = treeNodeQueue.poll()
                    currentRow.add(node.`val`)
                    node.left?.let { treeNodeQueue.add(it) }
                    node.right?.let { treeNodeQueue.add(it) }
                }
                if (currentRow.isEmpty()) return rowList.last().first()
                rowList.add(currentRow)
            }
            return rowList.last().first()
        }
    }
}
