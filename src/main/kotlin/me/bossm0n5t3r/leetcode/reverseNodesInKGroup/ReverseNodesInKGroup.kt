package me.bossm0n5t3r.leetcode.reverseNodesInKGroup

import me.bossm0n5t3r.leetcode.utils.ListNode

class ReverseNodesInKGroup {
    class Solution {
        fun reverseKGroup(head: ListNode?, k: Int): ListNode? =
            head
                ?.toList()
                ?.chunked(k)
                ?.flatMap { if (it.size == k) it.reversed() else it }
                ?.toListNode()

        private fun ListNode.toList(): List<Int> {
            val result = mutableListOf<Int>()
            var tmp = this as ListNode?
            while (tmp != null) {
                result.add(tmp.`val`)
                tmp = tmp.next
            }
            return result
        }

        private fun List<Int>.toListNode(): ListNode {
            val result = ListNode(this.first())
            var tmp = result as ListNode?
            for (i in 1 until this.size) {
                tmp?.next = ListNode(this[i])
                tmp = tmp?.next
            }
            return result
        }
    }
}
