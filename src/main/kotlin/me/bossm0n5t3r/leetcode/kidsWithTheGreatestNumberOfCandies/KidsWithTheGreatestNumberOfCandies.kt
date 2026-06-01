package me.bossm0n5t3r.leetcode.kidsWithTheGreatestNumberOfCandies

class KidsWithTheGreatestNumberOfCandies {
    class Solution {
        fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
            val maxCandies = candies.max() ?: 0
            return candies.map { (maxCandies - it) <= extraCandies }
        }
    }
}
