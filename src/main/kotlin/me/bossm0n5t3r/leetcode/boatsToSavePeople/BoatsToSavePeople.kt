package me.bossm0n5t3r.leetcode.boatsToSavePeople

class BoatsToSavePeople {
    class Solution {
        fun numRescueBoats(people: IntArray, limit: Int): Int {
            val sortedPeople = people.sorted()

            var boats = 0
            var (s, e) = 0 to sortedPeople.size - 1
            while (s <= e) {
                if (sortedPeople[s] + sortedPeople[e] <= limit) {
                    s++
                }
                e--
                boats++
            }

            return boats
        }
    }
}
