package me.bossm0n5t3r.leetcode.minimumcostofbuyingcandieswithdiscount

class MinimumCostOfBuyingCandiesWithDiscount {
    class Solution {
        fun minimumCost(cost: IntArray): Int =
            cost.sortedDescending().windowed(size = 3, step = 3, partialWindows = true).sumOf {
                it[0] + it.getOrElse(1) { 0 }
            }
    }
}
