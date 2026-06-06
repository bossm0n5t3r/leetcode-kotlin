package me.bossm0n5t3r.leetcode.totalwavinessofnumbersinrangeii

class TotalWavinessOfNumbersInRangeII {
    class Solution {
        fun totalWaviness(num1: Long, num2: Long): Long {
            return countTotalWavinessUpTo(num2) - countTotalWavinessUpTo(num1 - 1)
        }

        private fun countTotalWavinessUpTo(num: Long): Long {
            if (num < 100) return 0L

            // A number's waviness is the count of three consecutive digits where
            // the middle digit is either a peak or a valley.
            return wavePatterns.sumOf { pattern -> countPatternOccurrencesUpTo(num, pattern) }
        }

        private fun countPatternOccurrencesUpTo(num: Long, pattern: Int): Long {
            var occurrences = 0L
            var placeValue = 1L

            while (placeValue * 100 <= num) {
                occurrences += countPatternOccurrencesAtPlace(num, pattern, placeValue)
                placeValue *= 10
            }

            return occurrences
        }

        private fun countPatternOccurrencesAtPlace(
            num: Long,
            pattern: Int,
            placeValue: Long,
        ): Long {
            val higherPart = num / (placeValue * 1000)
            val currentBlock = (num / placeValue) % 1000
            val lowerPart = num % placeValue

            // Patterns smaller than 100 are written as 0xy.
            // The offset removes cases where that leading 0 would be outside the actual number.
            val leadingZeroOffset = if (pattern < 100) 1L else 0L
            var occurrences = 0L

            val completedPrefixCount =
                when {
                    currentBlock > pattern -> higherPart - leadingZeroOffset + 1
                    currentBlock == pattern.toLong() -> {
                        occurrences += lowerPart + 1
                        maxOf(0L, higherPart - leadingZeroOffset)
                    }
                    else -> maxOf(0L, higherPart - leadingZeroOffset)
                }

            occurrences += completedPrefixCount * placeValue
            return occurrences
        }

        companion object {
            // Among all 000..999 three-digit blocks, exactly 570 blocks are wave patterns.
            // For each fixed pair of left/right digits, the middle digit is a wave when it is
            // smaller than both or larger than both, so we preallocate that exact count.
            private val wavePatterns =
                IntArray(570).also { patterns ->
                    var index = 0
                    for (pattern in 0 until 1000) {
                        if (pattern.isWavePattern()) {
                            patterns[index++] = pattern
                        }
                    }
                }

            private fun Int.isWavePattern(): Boolean {
                val right = this % 10
                val middle = (this / 10) % 10
                val left = (this / 100) % 10

                return middle > maxOf(left, right) || middle < minOf(left, right)
            }
        }
    }
}
