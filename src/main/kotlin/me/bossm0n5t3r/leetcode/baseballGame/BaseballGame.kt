package me.bossm0n5t3r.leetcode.baseballGame

class BaseballGame {
    class Solution {
        fun calPoints(ops: Array<String>): Int {
            val record = mutableListOf<Int>()
            ops.forEach { op ->
                op.toIntOrNull()?.let { record.add(it) }
                    ?: when (op) {
                        "+" -> {
                            // Record a new score that is the sum of the previous two scores
                            val newScore = record.takeLast(2).sum()
                            record.add(newScore)
                        }

                        "D" -> {
                            // Record a new score that is double the previous score
                            val newScore = record.last() * 2
                            record.add(newScore)
                        }

                        "C" -> {
                            // Invalidate the previous score, removing it from the record
                            record.removeLast()
                        }

                        else -> {}
                    }
            }
            return record.sum()
        }
    }
}
