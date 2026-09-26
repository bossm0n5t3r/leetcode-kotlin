package me.bossm0n5t3r.leetcode.evaluatethebracketpairsofastring

class EvaluateTheBracketPairsOfAString {
    class Solution {
        fun evaluate(s: String, knowledge: List<List<String>>): String {
            val result = StringBuilder()
            val keyBuilder = StringBuilder()
            var inBracket = false
            val knowledgeMap = knowledge.associate { it.first() to it.last() }
            for (c in s) {
                when (c) {
                    '(' -> inBracket = true
                    ')' -> {
                        val key = keyBuilder.toString()
                        val value = knowledgeMap[key] ?: "?"
                        result.append(value)
                        inBracket = false
                        keyBuilder.clear()
                    }
                    else -> {
                        if (inBracket) {
                            keyBuilder.append(c)
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
