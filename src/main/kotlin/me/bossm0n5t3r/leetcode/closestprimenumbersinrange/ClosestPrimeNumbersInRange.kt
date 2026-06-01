package me.bossm0n5t3r.leetcode.closestprimenumbersinrange

class ClosestPrimeNumbersInRange {
    class Solution {
        fun closestPrimes(left: Int, right: Int): IntArray {
            val isPrime = generatePrimes(right)
            val candidates = (left..right).filter { isPrime[it] }
            if (candidates.size <= 1) return IntArray(2) { -1 }
            return candidates.windowed(2).minBy { it.last() - it.first() }.toIntArray()
        }

        private fun generatePrimes(until: Int): BooleanArray {
            val isPrime = BooleanArray(until + 1) { true }
            isPrime[0] = false
            isPrime[1] = false
            var sqrtUntil = 1
            while (sqrtUntil * sqrtUntil < until) {
                sqrtUntil++
            }
            for (i in 2..sqrtUntil) {
                if (isPrime[i]) {
                    var j = i * i
                    while (j <= until) {
                        isPrime[j] = false
                        j += i
                    }
                }
            }
            return isPrime
        }
    }
}
