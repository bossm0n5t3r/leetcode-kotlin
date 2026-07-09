package me.bossm0n5t3r.leetcode.pathexistencequeriesinagraphi

class PathExistenceQueriesInAGraphI {
    class Solution {
        fun pathExistenceQueries(
            n: Int,
            nums: IntArray,
            maxDiff: Int,
            queries: Array<IntArray>,
        ): BooleanArray {
            return queries.map { (u, v) -> nums.isStepExist(u, v, maxDiff) }.toBooleanArray()
        }

        private fun IntArray.isStepExist(start: Int, end: Int, maxDiff: Int): Boolean {
            if (start == end) return true
            if (start > end) return this.isStepExist(end, start, maxDiff)
            var num = this[start]
            for (i in (start + 1)..end) {
                val next = this[i]
                if (next - num > maxDiff) return false
                num = next
            }
            return true
        }
    }
}
