package me.bossm0n5t3r.leetcode.findchampionii

class FindChampionII {
    class Solution {
        fun findChampion(n: Int, edges: Array<IntArray>): Int {
            val candidates = (0 until n).toMutableSet()
            val weakTeam = mutableSetOf<Int>()
            for ((a, b) in edges) {
                candidates.remove(b)
                weakTeam.add(b)
                if (weakTeam.contains(a)) {
                    candidates.remove(a)
                }
            }
            return if (candidates.size == 1) candidates.first() else -1
        }
    }
}
