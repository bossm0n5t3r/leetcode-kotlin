package me.bossm0n5t3r.leetcode.findtheminimumandmaximumnumberofnodesbetweencriticalpoints

import me.bossm0n5t3r.leetcode.utils.ListNode

class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    class Solution {
        fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
            val points = mutableListOf<Int>()
            var tmp = head
            while (tmp != null) {
                points += tmp.`val`
                tmp = tmp.next
            }
            val criticalPointsIndices = points.getCriticalPointsIndices()
            if (criticalPointsIndices.size < 2) return intArrayOf(-1, -1)
            var minDistance = Int.MAX_VALUE
            for (i in 1 until criticalPointsIndices.size) {
                minDistance =
                    minOf(minDistance, criticalPointsIndices[i] - criticalPointsIndices[i - 1])
            }
            val maxDistance = criticalPointsIndices.last() - criticalPointsIndices.first()
            return intArrayOf(minDistance, maxDistance)
        }

        private fun List<Int>.getCriticalPointsIndices(): List<Int> {
            val result = mutableListOf<Int>()
            for (i in 1 until this.size - 1) {
                val prev = this[i - 1]
                val cur = this[i]
                val next = this[i + 1]
                if (prev < cur && next < cur) result += i
                if (cur < prev && cur < next) result += i
            }
            return result
        }
    }
}
