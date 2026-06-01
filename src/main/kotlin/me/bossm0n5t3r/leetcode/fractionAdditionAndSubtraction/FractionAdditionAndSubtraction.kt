package me.bossm0n5t3r.leetcode.fractionAdditionAndSubtraction

class FractionAdditionAndSubtraction {
    class Solution {
        companion object {
            private fun gcd(x: Long, y: Long): Long =
                when {
                    x < 0L -> gcd(-x, y)
                    y < 0L -> gcd(x, -y)
                    y > 0L -> gcd(y, x % y)
                    else -> x
                }

            private fun Fraction.makeIrreducible(): Fraction {
                if (this.numerator == 0L) return Fraction(0, 1)
                val gcd = gcd(this.numerator, this.denominator)
                return Fraction(this.numerator / gcd, this.denominator / gcd)
            }
        }

        data class Fraction(val numerator: Long, val denominator: Long) {
            operator fun plus(other: Fraction): Fraction =
                when {
                    this.denominator == other.denominator -> {
                        Fraction(this.numerator + other.numerator, this.denominator)
                    }

                    else -> {
                        Fraction(
                            this.numerator * other.denominator + other.numerator * this.denominator,
                            this.denominator * other.denominator,
                        )
                    }
                }.makeIrreducible()

            override fun toString(): String = "$numerator/$denominator"
        }

        operator fun Fraction.unaryMinus() = Fraction(-numerator, denominator)

        private fun String.toFraction(): Fraction {
            val (numerator, denominator) = this.split("/").map { it.toLong() }
            return Fraction(numerator, denominator)
        }

        fun fractionAddition(expression: String): String {
            var result = Fraction(0, 1)
            var isPlus = true
            var tmp = StringBuilder()
            for (c in expression) {
                when (c) {
                    '+' -> {
                        if (tmp.isNotBlank()) {
                            val tmpFraction = tmp.toString().toFraction()
                            result += if (isPlus) tmpFraction else -tmpFraction
                        }
                        isPlus = true
                        tmp = StringBuilder()
                    }

                    '-' -> {
                        if (tmp.isNotBlank()) {
                            val tmpFraction = tmp.toString().toFraction()
                            result += if (isPlus) tmpFraction else -tmpFraction
                        }
                        isPlus = false
                        tmp = StringBuilder()
                    }

                    else -> {
                        tmp.append(c)
                    }
                }
            }
            if (tmp.isNotBlank()) {
                val tmpFraction = tmp.toString().toFraction()
                result += if (isPlus) tmpFraction else -tmpFraction
            }
            return result.toString()
        }
    }
}
