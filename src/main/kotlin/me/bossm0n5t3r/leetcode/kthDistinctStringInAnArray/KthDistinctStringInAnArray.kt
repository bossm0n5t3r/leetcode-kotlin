package me.bossm0n5t3r.leetcode.kthDistinctStringInAnArray

class KthDistinctStringInAnArray {
    class Solution {
        fun kthDistinct(arr: Array<String>, k: Int): String {
            val distinctStringList = mutableListOf<String>()
            val visited = mutableSetOf<String>()
            for (string in arr) {
                if (visited.contains(string)) {
                    distinctStringList.remove(string)
                    continue
                }
                visited.add(string)
                distinctStringList.add(string)
            }
            return if (distinctStringList.size < k) "" else distinctStringList[k - 1]
        }
    }
}
