package me.bossm0n5t3r.leetcode.minimumscoreofapathbetweentwocities

class MinimumScoreOfAPathBetweenTwoCities {
    class Solution {
        fun minScore(n: Int, roads: Array<IntArray>): Int {
            val parent = IntArray(n + 1) { it }
            val minWeight = IntArray(n + 1) { Int.MAX_VALUE }

            fun find(x: Int): Int {
                var root = x
                while (parent[root] != root) {
                    parent[root] = parent[parent[root]]
                    root = parent[root]
                }
                return root
            }

            for ((u, v, w) in roads) {
                val rootU = find(u)
                val rootV = find(v)

                val mergedMin = minOf(minWeight[rootU], minWeight[rootV], w)

                if (rootU != rootV) {
                    parent[rootU] = rootV
                }
                minWeight[rootV] = mergedMin
            }

            return minWeight[find(1)]
        }
    }
}
