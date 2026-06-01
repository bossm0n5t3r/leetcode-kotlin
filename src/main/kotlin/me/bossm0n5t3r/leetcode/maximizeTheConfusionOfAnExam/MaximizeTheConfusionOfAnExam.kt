package me.bossm0n5t3r.leetcode.maximizeTheConfusionOfAnExam

class MaximizeTheConfusionOfAnExam {
    class Solution {
        fun maxConsecutiveAnswers(answerKey: String, k: Int): Int =
            maxOf(longestChars(answerKey, 'T', k), longestChars(answerKey, 'F', k))

        private fun longestChars(answerKey: String, targetChar: Char, k: Int): Int {
            var (s, e) = 0 to 0
            var flipCount = k
            while (e < answerKey.length) {
                if (answerKey[e] == targetChar) {
                    flipCount--
                }
                if (flipCount < 0) {
                    if (answerKey[s] == targetChar) {
                        flipCount++
                    }
                    s++
                }
                e++
            }
            return e - s
        }
    }
}
