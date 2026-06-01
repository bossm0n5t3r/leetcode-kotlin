package me.bossm0n5t3r.leetcode.divideanarrayintosubarrayswithminimumcostii

import java.util.TreeMap

class DivideAnArrayIntoSubarraysWithMinimumCostII {
    class Solution {
        private class SlidingWindowKSmallest(private val k: Int) {
            var currentSum = 0L
            private var lowerSize = 0
            private var upperSize = 0
            private val lowerSet = TreeMap<Int, Int>()
            private val upperSet = TreeMap<Int, Int>()

            fun add(x: Int) {
                if (upperSet.isNotEmpty() && x >= upperSet.firstKey()) {
                    addToMap(upperSet, x)
                    upperSize++
                } else {
                    addToMap(lowerSet, x)
                    lowerSize++
                    currentSum += x
                }
                rebalance()
            }

            fun remove(x: Int) {
                if (x in lowerSet) {
                    removeFromMap(lowerSet, x)
                    lowerSize--
                    currentSum -= x
                } else if (x in upperSet) {
                    removeFromMap(upperSet, x)
                    upperSize--
                }
                rebalance()
            }

            private fun rebalance() {
                while (lowerSize < k && upperSet.isNotEmpty()) {
                    val smallestInUpper = upperSet.firstKey()
                    moveElement(upperSet, lowerSet, smallestInUpper)
                    lowerSize++
                    upperSize--
                    currentSum += smallestInUpper
                }
                while (lowerSize > k) {
                    val largestInLower = lowerSet.lastKey()
                    moveElement(lowerSet, upperSet, largestInLower)
                    lowerSize--
                    upperSize++
                    currentSum -= largestInLower
                }
            }

            private fun addToMap(map: TreeMap<Int, Int>, key: Int) {
                map[key] = map.getOrDefault(key, 0) + 1
            }

            private fun removeFromMap(map: TreeMap<Int, Int>, key: Int) {
                val count = map[key] ?: return
                if (count == 1) map.remove(key) else map[key] = count - 1
            }

            private fun moveElement(from: TreeMap<Int, Int>, to: TreeMap<Int, Int>, key: Int) {
                removeFromMap(from, key)
                addToMap(to, key)
            }
        }

        fun minimumCost(nums: IntArray, k: Int, dist: Int): Long {
            val n = nums.size
            val window = SlidingWindowKSmallest(k - 2)

            for (i in 1 until k - 1) {
                window.add(nums[i])
            }

            var minCost = window.currentSum + nums[k - 1]
            for (i in k until n) {
                val outOfRangeIdx = i - dist - 1
                if (outOfRangeIdx > 0) {
                    window.remove(nums[outOfRangeIdx])
                }
                window.add(nums[i - 1])
                minCost = minOf(minCost, window.currentSum + nums[i])
            }
            return minCost + nums[0]
        }
    }
}
