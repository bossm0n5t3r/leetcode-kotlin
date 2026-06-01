package me.bossm0n5t3r.leetcode.palindromeLinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode

class PalindromeLinkedList {
    class Solution {
        /**
         * 1.
         *     1. head ListNode 로 부터 reverseListNode 를 구한다.
         *     2. 처음부터 끝까지 비교한다. ㄴ time complexity : O(2n) ㄴ space complexity : O(n)
         * 2. (current code)
         *     1. 중간 ListNode 를 구한다.
         *     2. 그리고 중간 ListNode 부터 reverseListNode 를 구한다.
         *     3. 절반만 비교한다. ㄴ time complexity : O(n) ㄴ space complexity : O(n/2)
         */
        fun isPalindrome(head: ListNode?): Boolean {
            val midListNode = getMidListNode(head)
            var reverseHalfListNode = getReverseListNode(midListNode)
            var cur = head
            while (reverseHalfListNode != null && cur != null) {
                if (reverseHalfListNode.`val` != cur.`val`) return false
                reverseHalfListNode = reverseHalfListNode.next
                cur = cur.next
            }
            return reverseHalfListNode == null || cur == null
        }

        private fun getMidListNode(head: ListNode?): ListNode? {
            var half = head
            var all = head
            while (all != null) {
                half = half?.next
                all = all.next?.next
            }
            return half
        }

        private fun getReverseListNode(head: ListNode?): ListNode? {
            var cur = head
            var reverseListNode: ListNode? = null
            while (cur != null) {
                val upper = ListNode(cur.`val`)
                upper.next = reverseListNode
                reverseListNode = upper
                cur = cur.next
            }
            return reverseListNode
        }
    }
}
