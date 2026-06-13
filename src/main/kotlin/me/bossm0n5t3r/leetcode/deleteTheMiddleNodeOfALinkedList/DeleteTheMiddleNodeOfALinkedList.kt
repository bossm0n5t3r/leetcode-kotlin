package me.bossm0n5t3r.leetcode.deleteTheMiddleNodeOfALinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode

class DeleteTheMiddleNodeOfALinkedList {
    class Solution {
        fun deleteMiddle(head: ListNode?): ListNode? {
            if (head?.next == null) return null
            var size = 0
            var tmp = head
            while (tmp != null) {
                size++
                tmp = tmp.next
            }
            size /= 2
            var move = head
            while (--size > 0) {
                move = move?.next
            }
            move?.next = move.next?.next
            return head
        }
    }
}
