package me.bossm0n5t3r.leetcode.minimumnumberofpushestotypewordi

class MinimumNumberOfPushesToTypeWordI {
    class Solution {
        fun minimumPushes(word: String): Int {
            val fullKeyGroups = word.length / KEYS_PER_PUSH_COUNT
            val remainingCharacters = word.length % KEYS_PER_PUSH_COUNT

            return KEYS_PER_PUSH_COUNT * fullKeyGroups * (fullKeyGroups + 1) / 2 +
                remainingCharacters * (fullKeyGroups + 1)
        }

        private companion object {
            const val KEYS_PER_PUSH_COUNT = 8
        }
    }
}
