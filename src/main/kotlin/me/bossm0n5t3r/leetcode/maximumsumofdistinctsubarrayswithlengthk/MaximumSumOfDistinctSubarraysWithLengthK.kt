package me.bossm0n5t3r.leetcode.maximumsumofdistinctsubarrayswithlengthk

import java.util.LinkedList
import java.util.Queue

class MaximumSumOfDistinctSubarraysWithLengthK {
    class Solution {
        fun maximumSubarraySum(nums: IntArray, k: Int): Long {
            val queue = LinkedList<Int>() as Queue<Int>
            val numCount = mutableMapOf<Int, Int>()
            var tmp = 0L
            for (i in 0 until k) {
                val num = nums[i]
                queue.offer(num)
                numCount[num] = numCount.getOrDefault(num, 0) + 1
                tmp += num
            }
            var result =
                if (numCount.size == k) {
                    tmp
                } else {
                    0
                }
            for (i in k until nums.size) {
                val removeNum = queue.poll()
                val removeNumCount = requireNotNull(numCount[removeNum]) - 1
                if (removeNumCount > 0) {
                    numCount[removeNum] = removeNumCount
                } else {
                    numCount.remove(removeNum)
                }
                tmp -= removeNum

                val addedNum = nums[i]
                queue.offer(addedNum)
                numCount[addedNum] = numCount.getOrDefault(addedNum, 0) + 1
                tmp += addedNum

                if (numCount.size == k) {
                    result = maxOf(result, tmp)
                }
            }
            return result
        }
    }
}
