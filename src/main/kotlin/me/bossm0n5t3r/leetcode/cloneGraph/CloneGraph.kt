package me.bossm0n5t3r.leetcode.cloneGraph

import me.bossm0n5t3r.leetcode.utils.Node

class CloneGraph {
    class Solution {
        fun cloneGraph(node: Node?): Node? {
            val cloneMap = mutableMapOf<Node, Node>()
            return clone(node, cloneMap)
        }

        private fun clone(node: Node?, map: MutableMap<Node, Node>): Node? {
            if (node == null) return null
            if (map.containsKey(node)) return map[node]

            val clonedNode = Node(node.`val`)
            map[node] = clonedNode

            for (neighbor in node.neighbors) {
                clonedNode.neighbors.add(clone(neighbor, map))
            }

            return clonedNode
        }
    }
}
