package me.bossm0n5t3r.leetcode.deleteNodesFromLinkedListPresentInArray

import me.bossm0n5t3r.leetcode.utils.ListNode

class DeleteNodesFromLinkedListPresentInArray {
    class Solution {
        fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
            val numberSet = nums.toSet()
            var head = head
            while (head != null && numberSet.contains(head.`val`)) {
                head = head.next
            }
            if (head == null) return null
            var current = head
            val result = current
            while (current?.next != null) {
                if (numberSet.contains(current.next?.`val`)) {
                    current.next = current.next?.next
                } else {
                    current = current.next
                }
            }
            return result
        }
    }
}
