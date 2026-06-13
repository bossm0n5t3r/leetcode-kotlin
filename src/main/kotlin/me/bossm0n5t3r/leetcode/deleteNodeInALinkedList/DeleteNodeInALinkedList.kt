package me.bossm0n5t3r.leetcode.deleteNodeInALinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode

class DeleteNodeInALinkedList {
    class Solution(val head: ListNode) {
        fun deleteNode(node: ListNode?) {
            node?.`val` = requireNotNull(node.next?.`val`)
            node?.next = node.next?.next
        }
    }
}
