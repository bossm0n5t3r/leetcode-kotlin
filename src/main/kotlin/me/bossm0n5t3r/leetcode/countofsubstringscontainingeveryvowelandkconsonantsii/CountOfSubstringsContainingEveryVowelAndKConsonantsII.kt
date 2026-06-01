package me.bossm0n5t3r.leetcode.countofsubstringscontainingeveryvowelandkconsonantsii

class CountOfSubstringsContainingEveryVowelAndKConsonantsII {
    class Solution {
        private fun Char.isVowel() = setOf('a', 'e', 'i', 'o', 'u').contains(this)

        fun countOfSubstrings(word: String, k: Int): Long {
            var result = 0L
            val vowelMap = mutableMapOf<Char, Int>()
            var consonantsCount = 0
            var (start, end) = 0 to 0

            fun shrinkWindow(word: String, index: Int) {
                if (word[index].isVowel()) {
                    vowelMap[word[index]] = vowelMap.getOrDefault(word[index], 0) - 1
                    if (vowelMap[word[index]] == 0) {
                        vowelMap.remove(word[index])
                    }
                } else {
                    consonantsCount--
                }
            }

            val nextConsonant = IntArray(word.length)
            var nextConsonantIndex = word.length
            for (i in word.length - 1 downTo 0) {
                nextConsonant[i] = nextConsonantIndex
                if (!word[i].isVowel()) {
                    nextConsonantIndex = i
                }
            }

            while (end < word.length) {
                val cur = word[end]
                when {
                    cur.isVowel() -> vowelMap[cur] = vowelMap.getOrDefault(cur, 0) + 1
                    else -> consonantsCount++
                }

                while (consonantsCount > k) {
                    shrinkWindow(word, start++)
                }

                while (start < word.length && vowelMap.size == 5 && consonantsCount == k) {
                    result += nextConsonant[end] - end
                    shrinkWindow(word, start++)
                }
                end++
            }

            return result
        }
    }
}
