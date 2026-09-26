package me.bossm0n5t3r.leetcode.evaluatethebracketpairsofastring

class EvaluateTheBracketPairsOfAString {
    class Solution {
        fun evaluate(s: String, knowledge: List<List<String>>): String {
            val result = StringBuilder()
            val queue = StringBuilder()
            var isBracket = false
            val knowledgeMap = knowledge.associate { it.first() to it.last() }
            for (c in s) {
                when (c) {
                    '(' -> isBracket = true
                    ')' -> {
                        isBracket = false
                        val key = queue.toString()
                        val value = knowledgeMap[key] ?: "?"
                        result.append(value)
                        queue.clear()
                    }
                    else -> {
                        if (isBracket) {
                            queue.append(c)
                        } else {
                            result.append(c)
                        }
                    }
                }
            }
            return result.toString()
        }
    }
}
