package me.bossm0n5t3r.leetcode.multiplyStrings

class MultiplyStrings {
    class Solution {
        private val zero = '0'.code

        fun multiply(num1: String, num2: String): String {
            val layer = mutableListOf<String>()
            var maxLength = 0
            (num2.length - 1 downTo 0).forEachIndexed { index, i ->
                val digit = num2[i]
                val tmp = multiplyOneDigit(num1, digit) + "0".repeat(index)
                if (maxLength < tmp.length) {
                    maxLength = tmp.length
                }
                layer.add(tmp)
            }
            val paddingZeroLayer = layer.map {
                if (it.length < maxLength) {
                    it.padStart(maxLength, '0')
                } else {
                    it
                }
            }
            var result = ""
            var jump = 0
            (maxLength - 1 downTo 0).forEach { i ->
                val tmp = paddingZeroLayer.sumOf { it[i].code - zero } + jump
                result = "${tmp % 10}$result"
                jump = tmp / 10
            }
            if (jump > 0) {
                result = "$jump$result"
            }
            while (result.length > 1 && result[0] == '0') {
                result = result.substring(1)
            }
            return result
        }

        private fun multiplyOneDigit(num1: String, digit: Char): String {
            val intDigit = digit.code - zero
            var result = ""
            var jump = 0
            (num1.length - 1 downTo 0).forEach { i ->
                val target = num1[i].code - zero
                val product = target * intDigit + jump
                result = "${product % 10}$result"
                jump = product / 10
            }
            if (jump > 0) {
                result = "$jump$result"
            }
            return result
        }
    }
}
