package me.bossm0n5t3r.leetcode.sumOfTwoIntegers

class SumOfTwoIntegers {
    class Solution {
        fun getSum(a: Int, b: Int): Int {
            val positiveA = a + 1000
            val positiveB = b + 1000
            // BinaryString 가져오기
            val binaryStringOfA = Integer.toBinaryString(positiveA)
            val binaryStringOfB = Integer.toBinaryString(positiveB)
            // 더 긴 BinaryString 에 대해서 계산
            val (extendedBinaryStringOfA, extendedBinaryStringOfB, length) =
                if (binaryStringOfA.length > binaryStringOfB.length) {
                    val diff = binaryStringOfA.length - binaryStringOfB.length
                    Triple(
                        binaryStringOfA,
                        addDummyBinaryString(binaryStringOfB, diff),
                        binaryStringOfA.length,
                    )
                } else {
                    val diff = binaryStringOfB.length - binaryStringOfA.length
                    Triple(
                        addDummyBinaryString(binaryStringOfA, diff),
                        binaryStringOfB,
                        binaryStringOfB.length,
                    )
                }
            var resultBinaryString = ""
            // 1000001010101
            // 0000000000101
            var addition = 0
            (length - 1 downTo 0).forEach { idx ->
                val charA = extendedBinaryStringOfA[idx]
                val charB = extendedBinaryStringOfB[idx]
                when {
                    charA == '0' && charB == '0' -> {
                        if (addition == 0) {
                            resultBinaryString = "0$resultBinaryString"
                        } else {
                            resultBinaryString = "1$resultBinaryString"
                            addition--
                        }
                    }

                    charA != charB -> {
                        resultBinaryString =
                            if (addition == 0) {
                                "1$resultBinaryString"
                            } else {
                                "0$resultBinaryString"
                            }
                    }

                    charA == '1' && charB == '1' -> {
                        if (addition == 0) {
                            resultBinaryString = "0$resultBinaryString"
                            addition++
                        } else {
                            resultBinaryString = "1$resultBinaryString"
                        }
                    }
                }
            }
            // 남은 addition 이 있으면 모두 계산해줍니다.
            if (addition > 0) {
                resultBinaryString = Integer.toBinaryString(addition) + resultBinaryString
            }
            return Integer.parseInt(resultBinaryString, 2) - 2000
        }

        private fun addDummyBinaryString(binaryString: String, length: Int): String =
            "0".repeat(length) + binaryString
    }
}
