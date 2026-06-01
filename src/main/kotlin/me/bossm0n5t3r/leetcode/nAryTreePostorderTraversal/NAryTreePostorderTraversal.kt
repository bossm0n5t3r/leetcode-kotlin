package me.bossm0n5t3r.leetcode.nAryTreePostorderTraversal

import me.bossm0n5t3r.leetcode.utils.Node

class NAryTreePostorderTraversal {
    class Solution {
        fun postorder(root: Node?): List<Int> {
            val result = mutableListOf<Int?>()
            traversal(root?.children, result)
            result.add(root?.`val`)
            return result.filterNotNull()
        }

        private fun traversal(children: List<Node?>?, result: MutableList<Int?>) {
            if (children == null) return
            for (child in children) {
                traversal(child?.children, result)
                result.add(child?.`val`)
            }
        }
    }
}
