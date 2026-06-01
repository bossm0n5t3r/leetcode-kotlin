package me.bossm0n5t3r.leetcode.removeZeroSumConsecutiveNodesFromLinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode

class RemoveZeroSumConsecutiveNodesFromLinkedList {
    class Solution {
        fun removeZeroSumSublists(head: ListNode?): ListNode? =
            head.toMutableList().removeAllZeroSumSubLists().toListNode()

        private fun ListNode?.toMutableList(): MutableList<Int> {
            val result = mutableListOf<Int>()
            var tmp = this
            while (tmp != null) {
                result.add(tmp.`val`)
                tmp = tmp.next
            }
            return result
        }

        private fun MutableList<Int>.removeAllZeroSumSubLists(): List<Int> {
            var copied = this.toList()
            var i = 0
            while (i < copied.size) {
                var sum = 0
                var j = i
                while (j < copied.size) {
                    sum += copied[j]
                    if (sum == 0) {
                        copied = copied.removeRange(i, j + 1)
                        i = -1
                        break
                    }
                    j++
                }
                i++
            }
            return copied
        }

        private fun List<Int>.removeRange(i: Int, j: Int): List<Int> =
            this.subList(0, i) + this.subList(j, this.size)

        private fun List<Int>.toListNode(): ListNode? {
            if (this.isEmpty()) return null
            val result = ListNode(this[0])
            var cur = result
            for (i in 1 until this.size) {
                cur.next = ListNode(this[i])
                cur = cur.next ?: error("cur.next is null")
            }
            return result
        }
    }
}
