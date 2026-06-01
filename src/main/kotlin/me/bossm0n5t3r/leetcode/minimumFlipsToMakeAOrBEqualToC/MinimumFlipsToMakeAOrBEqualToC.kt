package me.bossm0n5t3r.leetcode.minimumFlipsToMakeAOrBEqualToC

class MinimumFlipsToMakeAOrBEqualToC {
    class Solution {
        fun minFlips(a: Int, b: Int, c: Int): Int {
            val binaryAString = a.toString(2)
            val binaryBString = b.toString(2)
            val binaryCString = c.toString(2)

            val maxLength = maxOf(binaryAString.length, binaryBString.length, binaryCString.length)

            val updatedBinaryAString = binaryAString.padStart(maxLength, '0')
            val updatedBinaryBString = binaryBString.padStart(maxLength, '0')
            val updatedBinaryCString = binaryCString.padStart(maxLength, '0')

            var count = 0
            for (i in 0 until maxLength) {
                val charA = updatedBinaryAString[i]
                val charB = updatedBinaryBString[i]
                val charC = updatedBinaryCString[i]

                when (charC) {
                    '0' -> {
                        if (charA == '1') count++
                        if (charB == '1') count++
                    }

                    '1' -> {
                        if (charA == '0' && charB == '0') count++
                    }
                }
            }
            return count
        }
    }
}
