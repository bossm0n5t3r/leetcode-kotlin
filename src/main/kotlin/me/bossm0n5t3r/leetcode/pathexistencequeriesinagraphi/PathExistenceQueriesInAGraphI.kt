package me.bossm0n5t3r.leetcode.pathexistencequeriesinagraphi

class PathExistenceQueriesInAGraphI {
    class Solution {
        fun pathExistenceQueries(
            n: Int,
            nums: IntArray,
            maxDiff: Int,
            queries: Array<IntArray>,
        ): BooleanArray {
            var i = 0
            var j = 1

            var currentGroup = 0
            val nodeGroups = IntArray(n) { 0 }

            while (j < n) {
                val diff = nums[j] - nums[i]
                if (diff <= maxDiff) {
                    nodeGroups[i] = currentGroup
                    nodeGroups[j] = currentGroup
                } else {
                    nodeGroups[i] = currentGroup
                    currentGroup++
                    nodeGroups[j] = currentGroup
                }
                i++
                j++
            }

            val result = BooleanArray(queries.size) { false }
            for ((k, element) in queries.withIndex()) {
                val left = element[0]
                val right = element[1]
                if (left == right || (nodeGroups[left] == nodeGroups[right])) {
                    result[k] = true
                }
            }
            return result
        }
    }
}
