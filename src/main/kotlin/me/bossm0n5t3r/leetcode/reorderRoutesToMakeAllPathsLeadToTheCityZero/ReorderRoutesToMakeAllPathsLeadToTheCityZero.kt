package me.bossm0n5t3r.leetcode.reorderRoutesToMakeAllPathsLeadToTheCityZero

class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    class Solution {
        fun minReorder(n: Int, connections: Array<IntArray>): Int {
            val edges = Array<MutableList<Pair<Int, Boolean>>>(n) { mutableListOf() }
            for ((from, to) in connections) {
                edges[from].add(to to true)
                edges[to].add(from to false)
            }

            return dfs(edges, -1, 0)
        }

        private fun dfs(
            edges: Array<MutableList<Pair<Int, Boolean>>>,
            parent: Int,
            node: Int,
        ): Int {
            var result = 0
            for ((next, provided) in edges[node]) {
                if (next == parent) continue
                if (provided) result++
                result += dfs(edges, node, next)
            }
            return result
        }
    }
}
