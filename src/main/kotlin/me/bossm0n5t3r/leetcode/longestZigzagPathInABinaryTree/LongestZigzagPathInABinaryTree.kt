package me.bossm0n5t3r.leetcode.longestZigzagPathInABinaryTree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import java.util.Stack

class LongestZigzagPathInABinaryTree {
    class Solution {
        private enum class Direction {
            ROOT,
            LEFT,
            RIGHT,
        }

        private data class ZigZagCount(
            val dir: Direction,
            val count: Int = 0,
        )

        fun longestZigZag(root: TreeNode?): Int {
            if (root == null) return -1
            val stack =
                Stack<Pair<TreeNode, ZigZagCount>>().apply {
                    this.push(root to ZigZagCount(dir = Direction.ROOT))
                }
            var result = 0
            while (stack.isNotEmpty()) {
                val (cur, zigZagCount) = stack.pop()
                val curLeft = cur.left
                val curRight = cur.right
                result = maxOf(result, zigZagCount.count)
                when (zigZagCount.dir) {
                    Direction.ROOT -> {
                        if (curLeft != null) {
                            stack.push(
                                curLeft to
                                    ZigZagCount(
                                        dir = Direction.LEFT,
                                        count = 1,
                                    ),
                            )
                        }
                        if (curRight != null) {
                            stack.push(
                                curRight to
                                    ZigZagCount(
                                        dir = Direction.RIGHT,
                                        count = 1,
                                    ),
                            )
                        }
                    }

                    Direction.LEFT -> {
                        if (curLeft != null) {
                            stack.push(
                                curLeft to
                                    ZigZagCount(
                                        dir = Direction.LEFT,
                                        count = 1,
                                    ),
                            )
                        }
                        if (curRight != null) {
                            stack.push(
                                curRight to
                                    ZigZagCount(
                                        dir = Direction.RIGHT,
                                        count = zigZagCount.count + 1,
                                    ),
                            )
                        }
                    }

                    Direction.RIGHT -> {
                        if (curLeft != null) {
                            stack.push(
                                curLeft to
                                    ZigZagCount(
                                        dir = Direction.LEFT,
                                        count = zigZagCount.count + 1,
                                    ),
                            )
                        }
                        if (curRight != null) {
                            stack.push(
                                curRight to
                                    ZigZagCount(
                                        dir = Direction.RIGHT,
                                        count = 1,
                                    ),
                            )
                        }
                    }
                }
            }
            return result
        }
    }
}
