package me.bossm0n5t3r.leetcode.longestpalindromebyconcatenatingtwoletterwords

class LongestPalindromeByConcatenatingTwoLetterWords {
    class Solution {
        fun longestPalindrome(words: Array<String>): Int {
            val wordToCount = words.groupingBy { it }.eachCount()
            val visitedWords = mutableSetOf<String>()
            var longestPalindromeString = ""
            var result = 0
            for ((word, count) in wordToCount) {
                if (visitedWords.contains(word)) continue
                val isPalindrome = word.isPalindrome()
                if (isPalindrome) {
                    when {
                        count == 1 -> {
                            if (word.length > longestPalindromeString.length) {
                                longestPalindromeString = word
                            }
                        }

                        count % 2 == 0 -> {
                            result += (word.length * count)
                        }

                        else -> {
                            result += (word.length * (count - 1))
                            if (word.length > longestPalindromeString.length) {
                                longestPalindromeString = word
                            }
                        }
                    }
                    continue
                }
                val reversedWord = word.reversed()
                val reversedWordCount = wordToCount[reversedWord] ?: continue
                result += (word.length * 2 * minOf(count, reversedWordCount))
                visitedWords += word
                visitedWords += reversedWord
            }
            return result + longestPalindromeString.length
        }

        private fun String.isPalindrome() = this == this.reversed()
    }
}
