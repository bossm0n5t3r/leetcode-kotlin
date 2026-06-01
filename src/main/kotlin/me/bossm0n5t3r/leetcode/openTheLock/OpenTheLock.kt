package me.bossm0n5t3r.leetcode.openTheLock

import java.util.LinkedList
import java.util.Queue

class OpenTheLock {
    class Solution {
        private data class Lock(val first: Int, val second: Int, val third: Int, val fourth: Int) {
            constructor(
                str: String
            ) : this(
                str[0].toString().toInt(),
                str[1].toString().toInt(),
                str[2].toString().toInt(),
                str[3].toString().toInt(),
            )

            fun nextLocks(): List<Lock> =
                listOf(
                    Lock((first + 1) % 10, second, third, fourth),
                    Lock((first + 9) % 10, second, third, fourth),
                    Lock(first, (second + 1) % 10, third, fourth),
                    Lock(first, (second + 9) % 10, third, fourth),
                    Lock(first, second, (third + 1) % 10, fourth),
                    Lock(first, second, (third + 9) % 10, fourth),
                    Lock(first, second, third, (fourth + 1) % 10),
                    Lock(first, second, third, (fourth + 9) % 10),
                )

            override fun toString() = "$first$second$third$fourth"

            fun isEqualTo(target: String) = this.toString() == target
        }

        fun openLock(deadends: Array<String>, target: String): Int {
            val deadEndSet = deadends.toSet()
            val queue: Queue<Pair<Lock, Int>> =
                LinkedList<Pair<Lock, Int>>().apply { this.offer(Lock("0000") to 0) }
            val visited = mutableSetOf<String>()
            while (queue.isNotEmpty()) {
                val (cur, count) = queue.poll()
                if (deadEndSet.contains(cur.toString())) {
                    continue
                }
                if (cur.isEqualTo(target)) {
                    return count
                }
                visited.add(cur.toString())
                for (next in cur.nextLocks()) {
                    val nextString = next.toString()
                    if (
                        visited.contains(nextString).not() && deadEndSet.contains(nextString).not()
                    ) {
                        visited.add(nextString)
                        queue.offer(next to count + 1)
                    }
                }
            }
            return -1
        }
    }
}
