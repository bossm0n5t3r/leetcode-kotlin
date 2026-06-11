package me.bossm0n5t3r.leetcode.numberofwaystoassignedgeweightsi

class NumberOfWaysToAssignEdgeWeightsI {
    class Solution {
        fun assignEdgeWeights(edges: Array<IntArray>): Int {
            val graph = Array(edges.size + 2) { mutableListOf<Int>() }
            for (edge in edges) {
                val u = edge[0]
                val v = edge[1]
                graph[u].add(v)
                graph[v].add(u)
            }

            return powMod(exponent = maxDepth(graph) - 1)
        }

        private fun maxDepth(graph: Array<MutableList<Int>>): Int {
            val nodes = IntArray(graph.size)
            val parents = IntArray(graph.size)
            val depths = IntArray(graph.size)
            var size = 1
            var result = 0

            nodes[0] = 1

            while (size > 0) {
                size--
                val node = nodes[size]
                val parent = parents[size]
                val depth = depths[size]
                if (depth > result) result = depth

                for (next in graph[node]) {
                    if (next == parent) continue
                    nodes[size] = next
                    parents[size] = node
                    depths[size] = depth + 1
                    size++
                }
            }

            return result
        }

        private fun powMod(base: Int = 2, exponent: Int): Int {
            var value = base.toLong()
            var power = exponent
            var result = 1L

            while (power > 0) {
                if (power and 1 == 1) result = result * value % MOD
                value = value * value % MOD
                power = power shr 1
            }

            return result.toInt()
        }

        private companion object {
            const val MOD = 1_000_000_007
        }
    }
}
