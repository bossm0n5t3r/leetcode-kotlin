package me.bossm0n5t3r.leetcode.mergeKSortedLists

import java.util.PriorityQueue
import me.bossm0n5t3r.leetcode.utils.ListNode

class MergeKSortedLists {
    class Solution {
        fun mergeKLists(lists: Array<ListNode?>): ListNode? {
            if (lists.isEmpty() || lists.all { it == null }) return null
            val k = lists.size
            val result = ListNode(Int.MIN_VALUE)
            var iterator = result as ListNode?
            val pq = PriorityQueue<ListNode>(compareBy { it.`val` })
            for (list in lists) {
                if (list != null) {
                    pq.offer(list)
                }
            }
            while (pq.isNotEmpty()) {
                val curNode = pq.poll()
                iterator?.next = curNode
                iterator = iterator?.next
                if (curNode.next != null) {
                    pq.offer(curNode.next)
                }
            }

            return result.next
        }
    }
}
