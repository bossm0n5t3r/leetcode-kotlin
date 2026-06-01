package me.bossm0n5t3r.leetcode.mergeTwoSortedLists

import me.bossm0n5t3r.leetcode.utils.ListNode

class MergeTwoSortedLists {
    class Solution {
        fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
            if (l1 == null && l2 == null) return null
            if (l1 != null && l2 == null) return l1
            if (l1 == null && l2 != null) return l2
            val resultList = mutableListOf<Int>()
            var curL1 = l1
            var curL2 = l2
            while (curL1 != null || curL2 != null) {
                if (curL1 == null) {
                    while (curL2 != null) {
                        resultList.add(curL2.`val`)
                        curL2 = curL2.next
                    }
                    break
                }
                if (curL2 == null) {
                    while (curL1 != null) {
                        resultList.add(curL1.`val`)
                        curL1 = curL1.next
                    }
                    break
                }
                if (curL1.`val` <= curL2.`val`) {
                    resultList.add(curL1.`val`)
                    curL1 = curL1.next
                } else {
                    resultList.add(curL2.`val`)
                    curL2 = curL2.next
                }
            }
            val result = ListNode(resultList[0])
            var cur = result
            for (i in 1 until resultList.size) {
                cur.next = ListNode(resultList[i])
                cur = cur.next!!
            }
            return result
        }

        fun mergeTwoListsRecursive(l1: ListNode?, l2: ListNode?): ListNode? {
            if (l1 == null && l2 == null) return null
            if (l1 == null) return l2
            if (l2 == null) return l1
            return if (l1.`val` < l2.`val`) {
                l1.next = mergeTwoListsRecursive(l1.next, l2)
                l1
            } else {
                l2.next = mergeTwoListsRecursive(l2.next, l1)
                l2
            }
        }
    }
}
