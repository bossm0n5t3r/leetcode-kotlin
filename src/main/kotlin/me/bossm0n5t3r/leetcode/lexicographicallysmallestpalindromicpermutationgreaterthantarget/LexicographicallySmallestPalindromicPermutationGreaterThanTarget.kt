package me.bossm0n5t3r.leetcode.lexicographicallysmallestpalindromicpermutationgreaterthantarget

class LexicographicallySmallestPalindromicPermutationGreaterThanTarget {
    class Solution {
        fun lexPalindromicPermutation(s: String, target: String): String {
            val frequency = IntArray(26)
            for (c in s) frequency[c - 'a']++

            if (frequency.isPalindromic().not()) return ""

            val n = s.length
            val halfLength = n / 2

            val halfFrequency = IntArray(26)
            for (i in 0 until 26) halfFrequency[i] = frequency[i] / 2

            val middle =
                if (n % 2 == 1) {
                    val index = frequency.indexOfFirst { it % 2 == 1 }
                    'a' + index
                } else {
                    null
                }

            val left = StringBuilder()
            var matched = 0

            while (matched < halfLength && halfFrequency[target[matched] - 'a'] > 0) {
                val c = target[matched]
                halfFrequency[c - 'a']--
                left.append(c)
                matched++
            }

            if (matched == halfLength) {
                val candidate = buildPalindrome(left, middle)

                if (candidate > target) {
                    return candidate
                }
            } else {
                val greater = findGreater(halfFrequency, target[matched])

                if (greater != null) {
                    halfFrequency[greater - 'a']--
                    left.append(greater)

                    appendRemaining(left, halfFrequency)

                    return buildPalindrome(left, middle)
                }
            }

            for (i in matched - 1 downTo 0) {
                val removed = left[left.lastIndex]
                left.deleteCharAt(left.lastIndex)
                halfFrequency[removed - 'a']++

                val greater = findGreater(halfFrequency, target[i])

                if (greater != null) {
                    halfFrequency[greater - 'a']--
                    left.append(greater)

                    appendRemaining(left, halfFrequency)

                    return buildPalindrome(left, middle)
                }
            }

            return ""
        }

        private fun IntArray.isPalindromic(): Boolean {
            return this.count { it % 2 == 1 } <= 1
        }

        private fun findGreater(frequency: IntArray, target: Char): Char? {
            for (i in target - 'a' + 1 until 26) {
                if (frequency[i] > 0) {
                    return 'a' + i
                }
            }
            return null
        }

        private fun appendRemaining(result: StringBuilder, frequency: IntArray) {
            for (i in 0 until 26) {
                repeat(frequency[i]) { result.append('a' + i) }
            }
        }

        private fun buildPalindrome(left: StringBuilder, middle: Char?): String {
            return buildString {
                append(left)

                if (middle != null) {
                    append(middle)
                }

                for (i in left.lastIndex downTo 0) {
                    append(left[i])
                }
            }
        }
    }
}
