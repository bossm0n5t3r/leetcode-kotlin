package me.bossm0n5t3r.leetcode.guessNumberHigherOrLower

class GuessNumberHigherOrLower {
    abstract class GuessGame {
        private var n = 1
        private var pickedNumber = (1..n).random()

        abstract fun guessNumber(n: Int): Int

        fun init(
            n: Int,
            pick: Int,
        ) {
            this.n = n
            this.pickedNumber = pick
        }

        fun guess(num: Int): Int =
            when {
                num > pickedNumber -> -1
                num < pickedNumber -> 1
                else -> 0
            }
    }

    class Solution : GuessGame() {
        override fun guessNumber(n: Int): Int {
            var (start, end) = 1L to n.toLong()
            var mid = (start + end) / 2
            var response = guess(mid.toInt())
            while (response != 0) {
                when (response) {
                    -1 -> {
                        end = mid - 1
                    }

                    1 -> {
                        start = mid + 1
                    }

                    else -> {
                        error("Unknown result")
                    }
                }
                mid = (start + end) / 2
                response = guess(mid.toInt())
            }
            return mid.toInt()
        }
    }
}
