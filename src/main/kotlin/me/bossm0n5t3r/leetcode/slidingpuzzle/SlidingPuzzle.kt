package me.bossm0n5t3r.leetcode.slidingpuzzle

import java.util.LinkedList
import java.util.Queue

class SlidingPuzzle {
    class Solution {
        fun slidingPuzzle(board: Array<IntArray>): Int {
            val answer = "123450"
            val visited = mutableSetOf<String>()
            val queue = LinkedList<Pair<String, Int>>() as Queue<Pair<String, Int>>
            queue.offer("${board.first().joinToString("")}${board.last().joinToString("")}" to 0)
            while (queue.isNotEmpty()) {
                val (cur, move) = queue.poll()
                if (cur == answer) {
                    return move
                }
                visited.add(cur)
                for (candidate in cur.candidates()) {
                    if (visited.contains(candidate).not()) {
                        visited.add(candidate)
                        queue.offer(candidate to move + 1)
                    }
                }
            }
            return -1
        }

        private fun String.candidates(): List<String> =
            when {
                this[0] == '0' -> {
                    listOf(this.swap(0, 1), this.swap(0, 3))
                }

                this[1] == '0' -> {
                    listOf(this.swap(1, 0), this.swap(1, 2), this.swap(1, 4))
                }

                this[2] == '0' -> {
                    listOf(this.swap(2, 1), this.swap(2, 5))
                }

                this[3] == '0' -> {
                    listOf(this.swap(3, 0), this.swap(3, 4))
                }

                this[4] == '0' -> {
                    listOf(this.swap(4, 3), this.swap(4, 5), this.swap(4, 1))
                }

                this[5] == '0' -> {
                    listOf(this.swap(5, 4), this.swap(5, 2))
                }

                else -> {
                    error("Not found zero's r and c: $this")
                }
            }

        private fun String.swap(cur: Int, next: Int): String =
            this.toCharArray()
                .apply {
                    val tmp = this[cur]
                    this[cur] = this[next]
                    this[next] = tmp
                }
                .joinToString("")
    }
}
