package me.bossm0n5t3r.leetcode.insertGreatestCommonDivisorsInLinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode

class InsertGreatestCommonDivisorsInLinkedList {
    class Solution {
        fun insertGreatestCommonDivisors(head: ListNode?): ListNode? =
            head
                ?.toList()
                ?.takeIf { it.size > 1 }
                ?.windowed(2)
                ?.map { listOf(it.first(), it.first() gcd it.last(), it.last()) }
                ?.isLastOrNot()
                ?.map { (triple, isNotLast) ->
                    if (isNotLast) {
                        triple.subList(0, triple.size - 1)
                    } else {
                        triple
                    }
                }
                ?.flatten()
                ?.toListNode() ?: head

        private fun ListNode.toList(): List<Int> {
            val result = mutableListOf<Int>()
            var tmp = this as ListNode?
            while (tmp != null) {
                result.add(tmp.`val`)
                tmp = tmp.next
            }
            return result
        }

        private fun List<List<Int>>.isLastOrNot(): List<Pair<List<Int>, Boolean>> =
            this.foldIndexed(mutableListOf()) { index, acc, item ->
                acc.add(item to (index != this.lastIndex))
                acc
            }

        private infix fun Int.gcd(other: Int): Int {
            if (other == 0) return this
            return other gcd (this % other)
        }

        private fun List<Int>.toListNode(): ListNode {
            val result = ListNode(this.first())
            var tmp = result as ListNode?
            for (i in 1 until this.size) {
                tmp?.next = ListNode(this[i])
                tmp = tmp?.next
            }
            return result
        }
    }
}
