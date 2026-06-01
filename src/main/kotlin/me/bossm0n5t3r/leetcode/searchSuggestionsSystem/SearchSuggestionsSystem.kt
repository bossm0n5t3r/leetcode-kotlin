package me.bossm0n5t3r.leetcode.searchSuggestionsSystem

class SearchSuggestionsSystem {
    class Solution {
        companion object {
            private const val ALPHABET_SIZE = 26
            private const val ANSWER_SIZE = 3

            private class TrieNode {
                val children = Array<TrieNode?>(ALPHABET_SIZE) { null }
                val candidates = mutableListOf<String>()
                var isEndOfWord = false
            }
        }

        private val root = TrieNode()

        fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
            for (product in products) {
                insert(product)
            }
            var searchString = ""
            return searchWord.map { c ->
                searchString = "$searchString$c"
                startsWith(searchString)
            }
        }

        private fun insert(word: String) {
            var walk: TrieNode? = root
            for (c in word) {
                val index = c - 'a'
                if (walk?.children?.get(index) == null) {
                    walk?.children?.set(index, TrieNode())
                }
                walk?.candidates?.add(word)
                walk = walk?.children?.get(index)
            }
            walk?.candidates?.add(word)
            walk?.isEndOfWord = true
        }

        private fun startsWith(prefix: String): List<String> {
            var walk: TrieNode? = root
            for (c in prefix) {
                val index = c - 'a'
                if (walk?.children?.get(index) == null) return emptyList()
                walk = walk.children[index]
            }
            return walk?.candidates?.sorted()?.take(ANSWER_SIZE) ?: emptyList()
        }
    }
}
