package me.bossm0n5t3r.leetcode.relativeSortArray

class RelativeSortArray {
    class Solution {
        fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
            val numToCount = mutableMapOf<Int, Int>()
            for (num in arr1) {
                numToCount[num] = numToCount.getOrDefault(num, 0) + 1
            }
            val result = IntArray(arr1.size) { 0 }
            var index = 0
            for (num in arr2) {
                val count = numToCount[num] ?: continue
                repeat(count) { result[index++] = num }
                numToCount.remove(num)
            }
            for (sortedRemainedKey in numToCount.keys.sorted()) {
                val count = numToCount[sortedRemainedKey] ?: continue
                repeat(count) { result[index++] = sortedRemainedKey }
            }
            return result
        }

        fun relativeSortArrayUsingCountingSort(arr1: IntArray, arr2: IntArray): IntArray {
            val maxArr1 = arr1.max()
            val countArray = IntArray(maxArr1 + 1) { 0 }
            for (num in arr1) {
                countArray[num]++
            }
            val result = IntArray(arr1.size) { 0 }
            var index = 0
            for (num in arr2) {
                while (countArray[num]-- > 0) {
                    result[index++] = num
                }
            }
            for (i in countArray.indices) {
                while (countArray[i]-- > 0) {
                    result[index++] = i
                }
            }
            return result
        }
    }
}
