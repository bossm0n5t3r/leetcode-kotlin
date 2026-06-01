package me.bossm0n5t3r.leetcode.integerToRoman

class IntegerToRoman {
    class Solution {
        fun intToRoman(num: Int): String {
            val romanNumerals =
                mapOf(
                    0 to mapOf(1 to "I", 5 to "V"),
                    1 to mapOf(1 to "X", 5 to "L"),
                    2 to mapOf(1 to "C", 5 to "D"),
                    3 to mapOf(1 to "M"),
                )
            val result = mutableListOf<String?>()
            var tmpNum = num
            var idx = 0
            while (tmpNum > 0) {
                val tmp = tmpNum % 10
                val tmpDividedByFive = tmp / 5
                val tmpRemainderWhenDividedByFive = tmp % 5
                if (tmpRemainderWhenDividedByFive == 4) {
                    val tmpRoman =
                        romanNumerals[idx]?.get(1) +
                            if (tmpDividedByFive > 0) {
                                romanNumerals[idx + 1]?.get(1)
                            } else {
                                romanNumerals[idx]?.get(5)
                            }
                    result.add(tmpRoman)
                } else {
                    val tmpRoman =
                        (if (tmpDividedByFive > 0) {
                            romanNumerals[idx]?.get(5)
                        } else {
                            ""
                        }) + romanNumerals[idx]?.get(1)?.repeat(tmpRemainderWhenDividedByFive)
                    result.add(tmpRoman)
                }
                tmpNum /= 10
                idx++
            }
            return result.filterNotNull().reversed().joinToString("")
        }

        fun intToRomanAt20250109(num: Int): String {
            val valueToSymbol =
                mapOf(
                    1 to "I",
                    4 to "IV",
                    5 to "V",
                    9 to "IX",
                    10 to "X",
                    20 to "XX",
                    30 to "XXX",
                    40 to "XL",
                    50 to "L",
                    90 to "XC",
                    100 to "C",
                    200 to "CC",
                    300 to "CCC",
                    400 to "CD",
                    500 to "D",
                    900 to "CM",
                    1000 to "M",
                    2000 to "MM",
                    3000 to "MMM",
                )
            val reversedValues = valueToSymbol.keys.reversed()
            var number = num
            val result = StringBuilder()

            while (number > 0) {
                val target = reversedValues.first { number >= it }
                result.append(valueToSymbol[target])
                number -= target
            }

            return result.toString()
        }
    }
}
