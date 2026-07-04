package me.bossm0n5t3r.leetcode.minimumscoreofapathbetweentwocities

class MinimumScoreOfAPathBetweenTwoCities {
    class Solution {
        fun minScore(n: Int, roads: Array<IntArray>): Int {
            val adj = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
            for ((u, v, w) in roads) {
                adj[u].add(v to w)
                adj[v].add(u to w)
            }

            val visited = BooleanArray(n + 1)
            val stack = ArrayDeque<Int>()
            stack.add(1)
            visited[1] = true
            var result = Int.MAX_VALUE

            while (stack.isNotEmpty()) {
                val u = stack.removeLast()
                for ((v, w) in adj[u]) {
                    result = minOf(result, w)
                    if (!visited[v]) {
                        visited[v] = true
                        stack.add(v)
                    }
                }
            }

            return result
        }
    }
}
