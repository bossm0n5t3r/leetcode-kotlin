package me.bossm0n5t3r.leetcode.removeNthNodeFromEndOfList

import me.bossm0n5t3r.leetcode.utils.ListNode

class RemoveNthNodeFromEndOfList {
    class Solution {
        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            val valueList = mutableListOf<Int>()
            var cur = head
            while (cur != null) {
                valueList.add(cur.`val`)
                cur = cur.next
            }
            val valueListSize = valueList.size
            valueList.removeAt(valueListSize - n)
            if (valueList.isEmpty()) return null
            val result = ListNode(valueList.first())
            var curResult = result
            (1 until valueListSize - 1).forEach { i ->
                curResult.next = ListNode(valueList[i])
                curResult = curResult.next!!
            }
            return result
        }

        fun removeNthFromEndUsingPointers(head: ListNode?, n: Int): ListNode? {
            val start = ListNode(-1)
            var slow: ListNode? = start
            var fast: ListNode? = start
            slow?.next = head
            repeat(n + 1) { fast = fast?.next }
            while (fast != null) {
                fast = fast?.next
                slow = slow?.next
            }
            slow?.next = slow?.next?.next
            return start.next
        }
    }
}
