package me.bossm0n5t3r.leetcode.minimizexor

class MinimizeXOR {
    class Solution {
        fun minimizeXor(num1: Int, num2: Int): Int {
            val num1Bits = num1.countOneBits()
            val num2Bits = num2.countOneBits()
            if (num1Bits == num2Bits) return num1
            val tmp = num1.toString(2).padStart(32, '0').reversed().toCharArray()
            var (remainedOnes, before, after) =
                if (num1Bits < num2Bits) {
                    Triple(num2Bits - num1Bits, '0', '1')
                } else {
                    Triple(num1Bits - num2Bits, '1', '0')
                }
            while (remainedOnes-- > 0) {
                val index = tmp.indexOfFirst { it == before }
                tmp[index] = after
            }
            return String(tmp.reversedArray()).toInt(2)
        }
    }
}
