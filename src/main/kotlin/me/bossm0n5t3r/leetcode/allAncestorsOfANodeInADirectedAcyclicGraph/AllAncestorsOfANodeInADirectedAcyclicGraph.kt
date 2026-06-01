package me.bossm0n5t3r.leetcode.allAncestorsOfANodeInADirectedAcyclicGraph

class AllAncestorsOfANodeInADirectedAcyclicGraph {
    class Solution {
        fun getAncestors(n: Int, edges: Array<IntArray>): List<List<Int>> {
            val arr = Array(n) { mutableListOf<Int>() }
            for (edge in edges) {
                val (from, to) = edge
                arr[to] = arr[to].apply { this.add(from) }
            }
            return (0 until n).map { bfs(n, arr, it).sorted() }
        }

        private fun bfs(n: Int, arr: Array<MutableList<Int>>, cur: Int): List<Int> {
            val visited = BooleanArray(n) { false }
            visited[cur] = true
            val queue = mutableListOf(cur)
            val result = mutableListOf<Int>()
            while (queue.isNotEmpty()) {
                val curNode = queue.removeFirst()
                if (arr[curNode].isNotEmpty()) {
                    for (parentNode in arr[curNode]) {
                        if (visited[parentNode].not()) {
                            visited[parentNode] = true
                            result.add(parentNode)
                            queue.add(parentNode)
                        }
                    }
                }
            }
            return result
        }
    }
}
