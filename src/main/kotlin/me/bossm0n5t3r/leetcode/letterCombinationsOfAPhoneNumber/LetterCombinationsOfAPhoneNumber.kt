package me.bossm0n5t3r.leetcode.letterCombinationsOfAPhoneNumber

import java.util.LinkedList

class LetterCombinationsOfAPhoneNumber {
    class Solution {
        fun letterCombinations(digits: String): List<String> {
            if (digits.isBlank()) return emptyList()
            val digitToLetters =
                mapOf(
                    2 to listOf("a", "b", "c"),
                    3 to listOf("d", "e", "f"),
                    4 to listOf("g", "h", "i"),
                    5 to listOf("j", "k", "l"),
                    6 to listOf("m", "n", "o"),
                    7 to listOf("p", "q", "r", "s"),
                    8 to listOf("t", "u", "v"),
                    9 to listOf("w", "x", "y", "z"),
                )
            var result = mutableListOf<String>()
            var idx = 0
            while (idx < digits.length) {
                val targetDigit = digits[idx].digitToInt()
                val targetLetters = digitToLetters[targetDigit] ?: continue
                if (result.isEmpty()) {
                    result.addAll(targetLetters)
                } else {
                    result =
                        result.flatMap { first -> targetLetters.map { last -> "$first$last" } }
                            as MutableList<String>
                }
                idx++
            }
            return result
        }

        fun letterCombinationsGoodSolution(digits: String): List<String> {
            val result = LinkedList<String>()
            if (digits.isBlank()) return result
            val digitToLetters =
                arrayOf("0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
            result.add("")
            while (result.peek().length != digits.length) {
                val remove = result.remove()
                val targetDigit = digits[remove.length].digitToInt()
                (digitToLetters[targetDigit].toCharArray()).forEach { result.add("$remove$it") }
            }
            return result
        }

        fun letterCombinationsAt230829(digits: String): List<String> {
            val digitToLetters =
                mapOf(
                    '1' to listOf(""),
                    '2' to listOf("a", "b", "c"),
                    '3' to listOf("d", "e", "f"),
                    '4' to listOf("g", "h", "i"),
                    '5' to listOf("j", "k", "l"),
                    '6' to listOf("m", "n", "o"),
                    '7' to listOf("p", "q", "r", "s"),
                    '8' to listOf("t", "u", "v"),
                    '9' to listOf("w", "x", "y", "z"),
                    '0' to listOf(""),
                )

            val result = mutableListOf<String>()
            for (digit in digits) {
                val letters = digitToLetters[digit] ?: continue
                if (result.isEmpty()) {
                    result.addAll(letters)
                    continue
                }
                val newResult = mutableListOf<String>()
                for (letter in letters) {
                    for (item in result) {
                        newResult.add(item + letter)
                    }
                }
                result.clear()
                result.addAll(newResult)
            }
            return result
        }
    }
}
