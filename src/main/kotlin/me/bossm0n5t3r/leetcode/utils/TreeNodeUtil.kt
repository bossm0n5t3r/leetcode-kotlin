package me.bossm0n5t3r.leetcode.utils

import java.util.LinkedList
import java.util.Queue

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

object TreeNodeUtil {
    fun generateTreeNodeOrNull(data: List<Int?>): TreeNode? {
        if (data.isEmpty()) return null
        val length = data.size
        var index = 0
        val result = TreeNode(data[index]!!)
        index++
        val q: Queue<TreeNode?> = LinkedList()
        q.add(result)
        while (q.isNotEmpty()) {
            val size = q.size
            for (i in 0 until size) {
                val cur = q.poll()
                if (cur != null) {
                    if (index != length) {
                        cur.left = if (data[index] != null) TreeNode(data[index]!!) else null
                        index++
                        q.add(cur.left)
                    }
                    if (index != length) {
                        cur.right = if (data[index] != null) TreeNode(data[index]!!) else null
                        index++
                        q.add(cur.right)
                    }
                }
            }
        }
        return result
    }

    fun printTreeNode(treeNode: TreeNode?) {
        val q: Queue<TreeNode?> = LinkedList()
        q.add(treeNode)
        while (q.isNotEmpty()) {
            val size = q.size
            for (i in 0 until size) {
                val cur = q.poll()
                print("| ${cur?.`val`} |")
                if (cur != null) {
                    q.add(cur.left)
                    q.add(cur.right)
                }
            }
            println()
        }
    }

    fun isEqual(first: TreeNode?, second: TreeNode?): Boolean {
        if (first == null && second == null) return true
        if (first?.`val` != second?.`val`) return false
        val firstQ: Queue<TreeNode> = LinkedList()
        val secondQ: Queue<TreeNode> = LinkedList()
        firstQ.add(first)
        secondQ.add(second)
        while (true) {
            val firstQSize = firstQ.size
            val secondQSize = secondQ.size
            if (firstQSize != secondQSize) return false
            if (firstQSize == 0) return true
            for (i in 0 until firstQSize) {
                val firstCur = firstQ.poll()
                val secondCur = secondQ.poll()
                if (firstCur.`val` != secondCur.`val`) return false
                if (firstCur.left == null && secondCur.left != null) return false
                if (firstCur.left != null && secondCur.left == null) return false
                if (firstCur.right == null && secondCur.right != null) return false
                if (firstCur.right != null && secondCur.right == null) return false
                if (firstCur.left != null && secondCur.left != null) {
                    firstQ.add(firstCur.left)
                    secondQ.add(secondCur.left)
                }
                if (firstCur.right != null && secondCur.right != null) {
                    firstQ.add(firstCur.right)
                    secondQ.add(secondCur.right)
                }
            }
        }
    }
}
