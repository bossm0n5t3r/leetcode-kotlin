package me.bossm0n5t3r.leetcode.primenumberofsetbitsinbinaryrepresentation

class PrimeNumberOfSetBitsInBinaryRepresentation {
    class Solution {
        fun countPrimeSetBits(left: Int, right: Int): Int {
            val primes = setOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31)
            return (left..right).count { it.countOneBits() in primes }
        }
    }
}
