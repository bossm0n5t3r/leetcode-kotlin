package me.bossm0n5t3r.leetcode.spiralMatrixIV

import me.bossm0n5t3r.leetcode.utils.ListNode

class SpiralMatrixIV {
    class Solution {
        fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
            val result = Array(m) { IntArray(n) { -1 } }
            val visited = Array(m) { BooleanArray(n) { false } }
            var tmp = head
            var (r, c) = 0 to 0
            var direction = Direction.EAST
            while (tmp != null) {
                result[r][c] = tmp.`val`
                visited[r][c] = true
                tmp = tmp.next
                when (direction) {
                    Direction.NORTH -> r--
                    Direction.EAST -> c++
                    Direction.SOUTH -> r++
                    Direction.WEST -> c--
                }
                if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c]) {
                    when (direction) {
                        Direction.NORTH -> {
                            r++
                            direction = Direction.EAST
                            c++
                        }

                        Direction.EAST -> {
                            c--
                            direction = Direction.SOUTH
                            r++
                        }

                        Direction.SOUTH -> {
                            r--
                            direction = Direction.WEST
                            c--
                        }

                        Direction.WEST -> {
                            c++
                            direction = Direction.NORTH
                            r--
                        }
                    }
                }
            }
            return result
        }

        enum class Direction {
            NORTH,
            EAST,
            SOUTH,
            WEST,
        }
    }
}
