package me.bossm0n5t3r.leetcode.smallestStringWithSwaps

import java.util.PriorityQueue

class SmallestStringWithSwaps {
    class Solution {
        fun smallestStringWithSwaps(s: String, pairs: List<List<Int>>): String {
            val node = IntArray(s.length) { it }
            pairs.forEach { (x, y) -> union(node, x, y) }
            val map = mutableMapOf<Int, PriorityQueue<Char>>()
            s.indices.forEach { i ->
                val iRoot = find(node, i)
                node[i] = iRoot
                map[iRoot] = map.getOrDefault(iRoot, PriorityQueue<Char> { c1, c2 -> c1 - c2 })
                map[iRoot]?.offer(s[i])
            }
            val result = CharArray(s.length)
            s.indices.forEach { i ->
                val iRoot = node[i]
                result[i] = map[iRoot]?.poll() ?: '-'
            }
            return String(result)
        }

        private fun find(node: IntArray, x: Int): Int =
            if (node[x] == x) {
                x
            } else {
                node[x] = find(node, node[x])
                node[x]
            }

        private fun union(node: IntArray, x: Int, y: Int) {
            val xRoot = find(node, x)
            val yRoot = find(node, y)
            if (xRoot == yRoot) return
            if (xRoot > yRoot) {
                node[xRoot] = yRoot
            } else {
                node[yRoot] = xRoot
            }
        }
    }
}
