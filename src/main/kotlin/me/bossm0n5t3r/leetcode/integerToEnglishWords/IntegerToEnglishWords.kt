package me.bossm0n5t3r.leetcode.integerToEnglishWords

class IntegerToEnglishWords {
    class Solution {
        fun numberToWords(num: Int): String =
            num.toString()
                .reversed()
                .chunked(3)
                .withIndex()
                .reversed()
                .flatMap { (index, value) ->
                    numberUnderThousandToWord(value.reversed()) +
                        (commaToWord.takeIf { value != THREE_DIGITS_ZEROS }?.get(index) ?: "")
                }
                .filter { it.isNotBlank() }
                .joinToString(" ")

        private fun numberUnderThousandToWord(num: String): List<String> {
            if (num == TWO_DIGITS_ZEROS || num == THREE_DIGITS_ZEROS) return emptyList()

            return when (val number = num.toInt()) {
                in 0..20 -> {
                    listOf(numberToWord[number] ?: error("Not found number: $num"))
                }

                in 21 until 100 -> {
                    val (first, second) = (number / 10) * 10 to number % 10

                    listOf(
                        getWordFromNumberOrEmpty(first) { first != 0 },
                        getWordFromNumberOrEmpty(second) { second != 0 },
                    )
                }

                else -> {
                    val first = number / 100
                    listOf(getWordFromNumber(first), getWordFromNumber(100)) +
                        numberUnderThousandToWord(num.tail())
                }
            }
        }

        private fun String.head() = this.first().toString()

        private fun String.tail() = this.substring(1, this.length)

        private fun getWordFromNumber(num: Int) =
            numberToWord[num] ?: error("Not found number: $num")

        private fun getWordFromNumberOrEmpty(num: Int, condition: () -> Boolean) =
            numberToWord[num].takeIf { condition.invoke() } ?: ""

        companion object {
            private const val TWO_DIGITS_ZEROS = "00"
            private const val THREE_DIGITS_ZEROS = "000"

            private val commaToWord =
                mapOf(0 to "", 1 to "Thousand", 2 to "Million", 3 to "Billion")

            private val numberToWord =
                mapOf(
                    0 to "Zero",
                    1 to "One",
                    2 to "Two",
                    3 to "Three",
                    4 to "Four",
                    5 to "Five",
                    6 to "Six",
                    7 to "Seven",
                    8 to "Eight",
                    9 to "Nine",
                    10 to "Ten",
                    11 to "Eleven",
                    12 to "Twelve",
                    13 to "Thirteen",
                    14 to "Fourteen",
                    15 to "Fifteen",
                    16 to "Sixteen",
                    17 to "Seventeen",
                    18 to "Eighteen",
                    19 to "Nineteen",
                    20 to "Twenty",
                    30 to "Thirty",
                    40 to "Forty",
                    50 to "Fifty",
                    60 to "Sixty",
                    70 to "Seventy",
                    80 to "Eighty",
                    90 to "Ninety",
                    100 to "Hundred",
                )
        }
    }
}
