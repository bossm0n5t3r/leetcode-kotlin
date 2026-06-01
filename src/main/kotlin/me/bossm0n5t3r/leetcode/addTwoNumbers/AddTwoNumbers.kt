package me.bossm0n5t3r.leetcode.addTwoNumbers

import me.bossm0n5t3r.leetcode.utils.ListNode

class AddTwoNumbers {
    class Solution {
        fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
            if (l1 == null && l2 == null) return null
            val l1Val = l1?.`val` ?: 0
            val l2Val = l2?.`val` ?: 0
            val head = ListNode((l1Val + l2Val) % 10)
            var cur: ListNode? = head
            var temp = (l1Val + l2Val) / 10

            var copyL1 = l1?.next
            var copyL2 = l2?.next

            while (copyL1 != null || copyL2 != null || temp > 0) {
                val copyL1Val = copyL1?.`val` ?: 0
                val copyL2Val = copyL2?.`val` ?: 0
                cur?.next = ListNode((copyL1Val + copyL2Val + temp) % 10)
                temp = (copyL1Val + copyL2Val + temp) / 10
                cur = cur?.next
                copyL1 = copyL1?.next
                copyL2 = copyL2?.next
            }
            return head
        }
    }
}
