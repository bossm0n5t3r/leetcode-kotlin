package me.bossm0n5t3r.leetcode.pathSum3

import java.util.Stack
import me.bossm0n5t3r.leetcode.utils.TreeNode

class PathSum3 {
    class Solution {
        fun pathSum(root: TreeNode?, targetSum: Int): Int {
            if (root == null) return 0
            val result = mutableSetOf<Long>()
            val stack =
                Stack<Pair<TreeNode, Map<Long, Long>>>().apply { this.push(root to emptyMap()) }
            while (stack.isNotEmpty()) {
                val (cur, accumulatedMap) = stack.pop()
                val curLeft = cur.left
                val curRight = cur.right

                val nextAccumulatedMap =
                    accumulatedMap
                        .map { (k, v) -> (k + cur.hashCode().toLong()) to (v + cur.`val`.toLong()) }
                        .toMap() + (cur.hashCode().toLong() to cur.`val`.toLong())

                if (nextAccumulatedMap.values.contains(targetSum.toLong())) {
                    result.addAll(nextAccumulatedMap.filterValues { it == targetSum.toLong() }.keys)
                }

                if (curLeft != null) {
                    stack.push(curLeft to nextAccumulatedMap)
                }
                if (curRight != null) {
                    stack.push(curRight to nextAccumulatedMap)
                }
            }
            return result.size
        }
    }
}
