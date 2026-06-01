package me.bossm0n5t3r.leetcode.divisibleandnondivisiblesumsdifference

class DivisibleAndNonDivisibleSumsDifference {
    class Solution {
        fun differenceOfSums(n: Int, m: Int): Int {
            var dividable = 0
            var notDividable = 0
            for (i in 1..n) {
                if (i % m != 0) {
                    dividable += i
                } else {
                    notDividable += i
                }
            }
            return dividable - notDividable
        }
    }
}
