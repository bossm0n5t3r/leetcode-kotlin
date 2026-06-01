package me.bossm0n5t3r.leetcode.rotatelist

import me.bossm0n5t3r.leetcode.utils.ListNode

class RotateList {
    class Solution {
        fun rotateRight(head: ListNode?, k: Int): ListNode? {
            if (head == null || head.next == null || k == 0) {
                return head
            }
            val (length, tail) = head.lengthToTail()
            val steps = length - k % length
            if (steps == length) return head
            tail?.next = head

            var newTail = head
            for (i in 1 until steps) {
                newTail = newTail?.next
            }

            val result = newTail?.next
            newTail?.next = null

            return result
        }

        private fun ListNode?.lengthToTail(): Pair<Int, ListNode?> {
            var length = 1
            var tmp = this
            while (tmp?.next != null) {
                tmp = tmp.next
                length++
            }
            return length to tmp
        }
    }
}
