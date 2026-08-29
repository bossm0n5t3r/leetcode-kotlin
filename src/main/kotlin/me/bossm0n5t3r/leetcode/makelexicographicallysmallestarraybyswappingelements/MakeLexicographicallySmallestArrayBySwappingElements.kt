package me.bossm0n5t3r.leetcode.makelexicographicallysmallestarraybyswappingelements

class MakeLexicographicallySmallestArrayBySwappingElements {
    class Solution {
        fun lexicographicallySmallestArray(nums: IntArray, limit: Int): IntArray {
            val sorted = nums.withIndex().sortedBy { it.value }

            val groupByIndex = IntArray(nums.size)
            val valuesByGroup = mutableListOf<ArrayDeque<Int>>()

            var group = 0
            valuesByGroup += ArrayDeque<Int>()

            for (i in sorted.indices) {
                if (i > 0 && sorted[i].value - sorted[i - 1].value > limit) {
                    group++
                    valuesByGroup += ArrayDeque<Int>()
                }

                val (index, value) = sorted[i]

                groupByIndex[index] = group
                valuesByGroup[group].addLast(value)
            }

            val result = IntArray(nums.size)
            for (i in nums.indices) {
                val groupIndex = groupByIndex[i]
                result[i] = valuesByGroup[groupIndex].removeFirst()
            }
            return result
        }
    }
}
