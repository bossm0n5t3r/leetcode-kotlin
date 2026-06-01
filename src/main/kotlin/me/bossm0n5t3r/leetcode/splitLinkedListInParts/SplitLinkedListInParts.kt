package me.bossm0n5t3r.leetcode.splitLinkedListInParts

import me.bossm0n5t3r.leetcode.utils.ListNode

class SplitLinkedListInParts {
    class Solution {
        fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
            val intListOfHead = head?.toList() ?: emptyList()
            if (intListOfHead.isEmpty()) {
                return Array(k) { null }
            }
            return intListOfHead.splitBySize(k).map { it.toListNode() }.toTypedArray()
        }

        private fun ListNode.toList(): List<Int> {
            val result = mutableListOf<Int>()
            var tmp = this as ListNode?
            while (tmp != null) {
                result.add(tmp.`val`)
                tmp = tmp.next
            }
            return result
        }

        private fun List<Int>.splitBySize(k: Int): List<List<Int>> {
            var totalSize = this.size
            val eachSize = IntArray(k) { 0 }
            var index = 0
            while (totalSize-- > 0) {
                eachSize[index++]++
                if (index == k) {
                    index = 0
                }
            }
            val result = mutableListOf<List<Int>>()
            var (eachSizeIndex, totalIndex) = 0 to 0
            while (eachSizeIndex < k) {
                result.add(this.subList(totalIndex, totalIndex + eachSize[eachSizeIndex]))
                totalIndex += eachSize[eachSizeIndex++]
            }
            return result
        }

        private fun List<Int>.toListNode(): ListNode? {
            if (this.isEmpty()) return null
            val head = ListNode(this.first())
            var tmp = head as ListNode?
            var index = 1
            while (index < this.size) {
                tmp?.next = ListNode(this[index++])
                tmp = tmp?.next
            }
            return head
        }
    }
}
