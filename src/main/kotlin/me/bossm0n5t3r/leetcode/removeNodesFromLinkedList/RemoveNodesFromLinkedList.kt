package me.bossm0n5t3r.leetcode.removeNodesFromLinkedList

import java.util.Stack
import me.bossm0n5t3r.leetcode.utils.ListNode

class RemoveNodesFromLinkedList {
    class Solution {
        fun removeNodes(head: ListNode?): ListNode? {
            val stack = Stack<ListNode>()
            var tmp = head
            while (tmp != null) {
                while (stack.isNotEmpty() && stack.peek().`val` < tmp.`val`) {
                    stack.pop()
                }
                stack.push(tmp)
                tmp = tmp.next
            }
            if (stack.isEmpty()) return null
            val stackAsList = stack.toList()
            var result = stackAsList.first()
            for (i in 1 until stackAsList.size) {
                result.next = stackAsList[i]
                result = result.next
            }
            return stackAsList.first()
        }
    }
}
