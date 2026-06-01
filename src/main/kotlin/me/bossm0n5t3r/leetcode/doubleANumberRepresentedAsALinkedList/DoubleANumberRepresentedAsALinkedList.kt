package me.bossm0n5t3r.leetcode.doubleANumberRepresentedAsALinkedList

import java.math.BigDecimal
import me.bossm0n5t3r.leetcode.utils.ListNode

class DoubleANumberRepresentedAsALinkedList {
    class Solution {
        fun doubleIt(head: ListNode?): ListNode? {
            val numbers = mutableListOf<Int>()
            var tmp = head
            while (tmp != null) {
                numbers.add(tmp.`val`)
                tmp = tmp.next
            }
            val doublingNumberAsString =
                numbers.joinToString("").toBigDecimal().times(BigDecimal.valueOf(2L)).toString()
            val result = ListNode(doublingNumberAsString.first().toString().toInt()) as ListNode?
            var tmpResult = result
            for (i in 1 until doublingNumberAsString.length) {
                tmpResult?.next = ListNode(doublingNumberAsString[i].toString().toInt())
                tmpResult = tmpResult?.next
            }
            return result
        }
    }
}
