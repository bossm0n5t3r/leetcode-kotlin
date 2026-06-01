package me.bossm0n5t3r.leetcode.longestCommonPrefix

class LongestCommonPrefix {
    class Solution {
        fun longestCommonPrefixFirst(strs: Array<String>): String {
            val length = strs.size
            if (length == 1) return strs.first()
            if (length == 2) return commonPrefix(strs.first(), strs.last())
            var commonPrefix = commonPrefix(strs[0], strs[1])
            var index = 2
            while (commonPrefix.isNotEmpty() && index < length) {
                commonPrefix = commonPrefix(commonPrefix, strs[index])
                index++
            }
            return commonPrefix
        }

        private fun commonPrefix(first: String, second: String): String {
            val shortLength = if (first.length <= second.length) first.length else second.length
            for (i in 0 until shortLength) {
                if (first[i] != second[i]) {
                    return first.substring(0, i)
                }
            }
            return first.substring(0, shortLength)
        }

        fun longestCommonPrefixSecond(strs: Array<String>): String {
            if (strs.isEmpty()) return ""
            for (i in 0 until strs.first().length) {
                val c = strs.first()[i]
                for (j in 1 until strs.size) {
                    if (i == strs[j].length || c != strs[j][i]) {
                        return strs.first().substring(0, i)
                    }
                }
            }
            return strs.first()
        }

        fun longestCommonPrefixThird(strs: Array<String>): String {
            if (strs.isEmpty()) return ""
            return longestCommonPrefixThird(strs, 0, strs.size - 1)
        }

        private fun longestCommonPrefixThird(strs: Array<String>, left: Int, right: Int): String {
            if (left == right) return strs[left]
            val mid = (left + right) / 2
            val leftLongestCommonPrefix = longestCommonPrefixThird(strs, left, mid)
            val rightLongestCommonPrefix = longestCommonPrefixThird(strs, mid + 1, right)
            return commonPrefix(leftLongestCommonPrefix, rightLongestCommonPrefix)
        }

        fun longestCommonPrefixFourth(strs: Array<String>): String {
            if (strs.isEmpty()) return ""
            val minLen = strs.minOf { it.length }
            var low = 0
            var high = minLen
            while (low <= high) {
                val middle = (low + high) / 2
                if (isCommonPrefix(strs, middle)) {
                    low = middle + 1
                } else {
                    high = middle - 1
                }
            }
            return strs[0].substring(0, (low + high) / 2)
        }

        private fun isCommonPrefix(strs: Array<String>, len: Int): Boolean {
            val first = strs[0].substring(0, len)
            for (i in 1 until strs.size) {
                if (!strs[i].startsWith(first)) return false
            }
            return true
        }

        fun longestCommonPrefixTrie(strs: Array<String>): String {
            if (strs.isEmpty()) return ""
            val trie = Trie()
            for (str in strs) {
                trie.insert(str)
            }
            return trie.searchLongestPrefix(strs.first())
        }

        internal class TrieNode {
            // R links to node children
            private val links: Array<TrieNode?>
            private val r = 26
            var size = 0
                private set

            var isEnd = false
                private set

            fun containsKey(ch: Char): Boolean = links[ch - 'a'] != null

            operator fun get(ch: Char): TrieNode? = links[ch - 'a']

            fun put(ch: Char, node: TrieNode?) {
                links[ch - 'a'] = node
                size++
            }

            fun setEnd() {
                isEnd = true
            }

            init {
                links = arrayOfNulls(r)
            }
        }

        internal class Trie {
            private val root: TrieNode = TrieNode()

            // Inserts a word into the trie.
            fun insert(word: String) {
                var node: TrieNode? = root
                for (element in word) {
                    if (!node!!.containsKey(element)) {
                        node.put(element, TrieNode())
                    }
                    node = node[element]
                }
                node!!.setEnd()
            }

            fun searchLongestPrefix(word: String): String {
                var node: TrieNode? = root
                val prefix = mutableListOf<Char>()
                for (ch in word) {
                    if (node!!.containsKey(ch) && (node.size == 1) && !node.isEnd) {
                        prefix.add(ch)
                        node = node[ch]
                    } else {
                        break
                    }
                }
                return prefix.joinToString("")
            }
        }

        fun longestCommonPrefixAt20250109(strs: Array<String>): String {
            val trie = TrieAt20250109()
            for (str in strs) {
                trie.insert(str)
            }
            return trie.getLongestCommonPrefix()
        }

        internal class TrieAt20250109 {
            companion object {
                private const val ALPHABET_SIZE = 26

                private class TrieNode {
                    val children = arrayOfNulls<TrieNode?>(ALPHABET_SIZE)
                    var isEndOfWord = false
                }
            }

            private val root = TrieNode()

            fun insert(word: String) {
                var walk: TrieNode? = root
                for (c in word) {
                    val index = c - 'a'
                    if (walk?.children?.get(index) == null) {
                        walk?.children?.set(index, TrieNode())
                    }
                    walk = walk?.children?.get(index)
                }
                walk?.isEndOfWord = true
            }

            fun getLongestCommonPrefix(): String {
                var walk: TrieNode? = root
                val result = StringBuilder()
                while (walk?.isEndOfWord == false && walk.children.count { it != null } == 1) {
                    val index = walk.children.indexOfFirst { it != null }
                    result.append('a' + index)
                    walk = walk.children[index]
                }
                return result.toString()
            }
        }
    }
}
