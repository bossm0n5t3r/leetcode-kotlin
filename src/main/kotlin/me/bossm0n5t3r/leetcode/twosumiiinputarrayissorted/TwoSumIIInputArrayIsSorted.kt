package me.bossm0n5t3r.leetcode.twosumiiinputarrayissorted

class TwoSumIIInputArrayIsSorted {
    class Solution {
        fun twoSum(numbers: IntArray, target: Int): IntArray {
            var (s, e) = 0 to numbers.lastIndex
            while (s < e) {
                val sum = numbers[s] + numbers[e]
                when {
                    sum == target -> return intArrayOf(s + 1, e + 1)
                    sum > target -> e--
                    else -> s++
                }
            }
            return intArrayOf(s + 1, e + 1)
        }
    }
}
