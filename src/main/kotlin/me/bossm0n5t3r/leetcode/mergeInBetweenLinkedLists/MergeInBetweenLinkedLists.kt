package me.bossm0n5t3r.leetcode.mergeInBetweenLinkedLists

import me.bossm0n5t3r.leetcode.utils.ListNode

class MergeInBetweenLinkedLists {
    class Solution {
        fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
            var currNode = list1
            var index = 0
            while (index < a - 1) {
                currNode = currNode?.next
                index++
            }
            val front = currNode
            while (index < b + 1) {
                currNode = currNode?.next
                index++
            }
            val rear = currNode
            var secondListTail = list2
            while (secondListTail?.next != null) {
                secondListTail = secondListTail.next
            }
            front?.next = list2
            secondListTail?.next = rear
            return list1
        }
    }
}
