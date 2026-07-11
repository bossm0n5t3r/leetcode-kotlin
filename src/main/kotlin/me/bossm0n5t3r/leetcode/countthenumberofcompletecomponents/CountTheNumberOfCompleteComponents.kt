package me.bossm0n5t3r.leetcode.countthenumberofcompletecomponents

class CountTheNumberOfCompleteComponents {
    class Solution {
        fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
            val graph = Array(n) { mutableListOf<Int>() }

            for (edge in edges) {
                val u = edge[0]
                val v = edge[1]
                graph[u].add(v)
                graph[v].add(u)
            }

            val visited = BooleanArray(n)
            var result = 0

            fun dfs(node: Int, component: MutableList<Int>) {
                visited[node] = true
                component.add(node)

                for (next in graph[node]) {
                    if (!visited[next]) {
                        dfs(next, component)
                    }
                }
            }

            for (i in 0 until n) {
                if (!visited[i]) {
                    val component = mutableListOf<Int>()
                    dfs(i, component)

                    val nodes = component.size
                    var degreeSum = 0

                    for (node in component) {
                        degreeSum += graph[node].size
                    }

                    val actualEdges = degreeSum / 2
                    val requiredEdges = nodes * (nodes - 1) / 2

                    if (actualEdges == requiredEdges) {
                        result++
                    }
                }
            }
            return result
        }
    }
}
