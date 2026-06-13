package me.bossm0n5t3r.leetcode.mergeNodesInBetweenZeros

import me.bossm0n5t3r.leetcode.utils.ListNode

class MergeNodesInBetweenZeros {
    class Solution {
        fun mergeNodes(head: ListNode?): ListNode? {
            val result = ListNode(0)
            var resultIterator = result as ListNode?
            var tmp: ListNode? = head
            while (tmp != null) {
                val value = tmp.`val`
                tmp = tmp.next
                if (value == 0) {
                    if (tmp != null) {
                        resultIterator?.next = ListNode(0)
                        resultIterator = resultIterator?.next
                    }
                    continue
                }
                resultIterator?.`val` = resultIterator.`val` + value
            }
            return result.next
        }
    }
}
