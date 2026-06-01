package me.bossm0n5t3r.leetcode.grumpyBookstoreOwner

class GrumpyBookstoreOwner {
    class Solution {
        fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
            val n = customers.size
            var startMinute = 0
            var endMinute = minutes - 1
            var tmp = 0
            for (i in 0 until n) {
                if (i in startMinute..endMinute || grumpy[i] == 0) {
                    tmp += customers[i]
                }
            }
            var result = tmp
            while (endMinute + 1 < n) {
                if (grumpy[startMinute] == 1) {
                    tmp -= customers[startMinute]
                }
                startMinute++
                if (grumpy[++endMinute] == 1) {
                    tmp += customers[endMinute]
                }
                result = maxOf(result, tmp)
            }
            return result
        }
    }
}
