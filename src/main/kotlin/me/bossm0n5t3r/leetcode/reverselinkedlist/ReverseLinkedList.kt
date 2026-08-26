package me.bossm0n5t3r.leetcode.reverselinkedlist

import kotlin.random.Random
import me.bossm0n5t3r.leetcode.utils.ListNode

class ReverseLinkedList {
    class Solution {
        private val isIteratively = Random.nextBoolean()

        fun reverseList(head: ListNode?): ListNode? {
            return if (isIteratively) reverseIteratively(head) else reverseRecursively(head)
        }

        private fun reverseIteratively(head: ListNode?): ListNode? {
            var prev: ListNode? = null
            var cur = head

            while (cur != null) {
                val next = cur.next
                cur.next = prev
                prev = cur
                cur = next
            }

            return prev
        }

        private fun reverseRecursively(head: ListNode?): ListNode? {
            if (head?.next == null) {
                return head
            }

            val newHead = reverseRecursively(head.next)

            head.next?.next = head
            head.next = null

            return newHead
        }
    }
}
