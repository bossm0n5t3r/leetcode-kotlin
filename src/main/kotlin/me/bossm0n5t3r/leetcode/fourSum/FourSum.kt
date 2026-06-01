package me.bossm0n5t3r.leetcode.fourSum

class FourSum {
    class Solution {
        fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
            if (nums.size <= 3) return emptyList()
            if (nums.size == 4 && nums.sum() == target) return listOf(nums.toList())
            val result = mutableSetOf<List<Int>>()
            val sortedNums = nums.sorted()
            for (i in 0 until sortedNums.size - 3) {
                for (j in i + 1 until sortedNums.size - 2) {
                    var low = j + 1
                    var high = sortedNums.size - 1
                    val sum = target - sortedNums[i] - sortedNums[j]
                    while (low < high) {
                        if (sortedNums[low] + sortedNums[high] == sum) {
                            result.add(
                                listOf(
                                    sortedNums[i],
                                    sortedNums[j],
                                    sortedNums[low],
                                    sortedNums[high],
                                )
                            )
                            while (low < high && sortedNums[low] == sortedNums[low + 1]) {
                                low++
                            }
                            while (low < high && sortedNums[high - 1] == sortedNums[high]) {
                                high--
                            }
                            low++
                            high--
                        } else if (sortedNums[low] + sortedNums[high] < sum) {
                            low++
                        } else if (sortedNums[low] + sortedNums[high] > sum) {
                            high--
                        }
                    }
                }
            }
            return result.toList()
        }
    }
}
