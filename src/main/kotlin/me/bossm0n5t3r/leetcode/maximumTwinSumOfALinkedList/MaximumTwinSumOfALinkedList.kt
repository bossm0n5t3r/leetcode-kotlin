package me.bossm0n5t3r.leetcode.maximumTwinSumOfALinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode

class MaximumTwinSumOfALinkedList {
    class Solution {
        fun pairSum(head: ListNode?): Int {
            var curHead = head
            var reverse = reverseNode(head)
            var result = Int.MIN_VALUE
            while (curHead != null && reverse != null) {
                val tmp = curHead.`val` + reverse.`val`
                result = maxOf(result, tmp)
                curHead = curHead.next
                reverse = reverse.next
            }
            return result
        }

        private fun reverseNode(head: ListNode?): ListNode? {
            if (head?.next == null) return head
            var cur = head
            var last: ListNode? = null
            var tmp: ListNode
            while (cur != null) {
                tmp = ListNode(cur.`val`)
                tmp.next = last
                last = tmp
                cur = cur.next
            }
            return last
        }
    }
}
