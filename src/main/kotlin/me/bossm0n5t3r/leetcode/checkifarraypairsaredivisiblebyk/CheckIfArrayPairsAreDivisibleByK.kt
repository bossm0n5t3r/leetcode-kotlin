package me.bossm0n5t3r.leetcode.checkifarraypairsaredivisiblebyk

class CheckIfArrayPairsAreDivisibleByK {
    class Solution {
        fun canArrange(arr: IntArray, k: Int): Boolean {
            val remainder =
                arr.toList().groupBy {
                    var tmp = it
                    while (tmp < 0) {
                        tmp += k
                    }
                    tmp % k
                }
            for (i in 1..(k / 2)) {
                val remainderFirst = remainder[i] ?: emptyList()
                val remainderSecond = remainder[k - i] ?: emptyList()
                if (remainderFirst.size != remainderSecond.size) {
                    return false
                }
            }
            if (k % 2 == 0) {
                val remainderInMiddle = remainder[k / 2] ?: emptyList()
                if (remainderInMiddle.size % 2 != 0) {
                    return false
                }
            }
            return true
        }
    }
}
