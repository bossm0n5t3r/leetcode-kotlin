package me.bossm0n5t3r.leetcode.sumofprefixscoresofstrings

class SumOfPrefixScoresOfStrings {
    class Solution {
        private class TrieNode(val links: Array<TrieNode?> = arrayOfNulls(26), var score: Int = 0)

        private fun insert(root: TrieNode, word: String) {
            var node = root as TrieNode?
            for (c in word) {
                val index = c - 'a'
                if (node?.links?.get(index) == null) {
                    node?.links?.set(index, TrieNode())
                }
                node = node?.links?.get(index)
                node?.score = node.score + 1
            }
        }

        private fun calculateSumOfPrefixScores(root: TrieNode, word: String): Int {
            var sum = 0
            var node = root as TrieNode?
            for (c in word) {
                node = node?.links?.get(c - 'a')
                sum += node?.score ?: 0
            }
            return sum
        }

        fun sumPrefixScores(words: Array<String>): IntArray {
            val trieRoot = TrieNode()
            for (word in words) {
                insert(trieRoot, word)
            }
            return words.map { calculateSumOfPrefixScores(trieRoot, it) }.toIntArray()
        }
    }
}
