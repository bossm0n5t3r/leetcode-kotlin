package me.bossm0n5t3r.leetcode.maximumscorefromremovingsubstrings

class MaximumScoreFromRemovingSubstrings {
    class Solution {
        fun maximumGain(s: String, x: Int, y: Int): Int {
            val operationX: Pair<String, Int>.() -> Pair<String, Int> = { gainScore("ab", x) }
            val operationY: Pair<String, Int>.() -> Pair<String, Int> = { gainScore("ba", y) }

            return if (x > y) {
                    (s to 0).operationX().operationY()
                } else {
                    (s to 0).operationY().operationX()
                }
                .second
        }

        private fun Pair<String, Int>.gainScore(target: String, score: Int): Pair<String, Int> {
            val stack = ArrayDeque<Char>()
            var currentScore = this.second
            val targetFirstChar = target[0]
            val targetSecondChar = target[1]

            for (char in this.first) {
                if (
                    char == targetSecondChar &&
                        stack.isNotEmpty() &&
                        stack.last() == targetFirstChar
                ) {
                    stack.removeLast()
                    currentScore += score
                } else {
                    stack.addLast(char)
                }
            }
            return stack.joinToString("") to currentScore
        }
    }
}
