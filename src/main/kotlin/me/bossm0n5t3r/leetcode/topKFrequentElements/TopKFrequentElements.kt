package me.bossm0n5t3r.leetcode.topKFrequentElements

class TopKFrequentElements {
    class Solution {
        fun topKFrequent(nums: IntArray, k: Int): IntArray {
            val freqPairList = getFreqPairList(nums)
            return if (k >= freqPairList.size) {
                freqPairList.map { (key, _) -> key }.toIntArray()
            } else {
                freqPairList.subList(0, k).map { (key, _) -> key }.toIntArray()
            }
        }

        private fun getFreqPairList(nums: IntArray): List<Pair<Int, Int>> {
            val result = mutableMapOf<Int, Int>()
            nums.forEach { num -> result[num] = result.getOrDefault(num, 0) + 1 }
            return result.toList().sortedByDescending { (_, value) -> value }
        }
    }
}
