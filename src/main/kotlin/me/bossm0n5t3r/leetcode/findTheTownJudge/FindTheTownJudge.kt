package me.bossm0n5t3r.leetcode.findTheTownJudge

class FindTheTownJudge {
    class Solution {
        fun findJudge(n: Int, trust: Array<IntArray>): Int {
            val townPeople = (1..n).toMutableSet()
            val reverseTrustMap = mutableMapOf<Int, MutableSet<Int>>()
            for ((from, to) in trust) {
                townPeople.remove(from)
                reverseTrustMap[to] =
                    reverseTrustMap.getOrDefault(to, mutableSetOf()).apply { this.add(from) }
            }
            if (townPeople.size != 1) {
                return -1
            }
            val expectTownJudge = townPeople.first()
            val peopleWhoTrustExpectTownJudge = reverseTrustMap[expectTownJudge] ?: emptySet()
            if (
                peopleWhoTrustExpectTownJudge.size == n - 1 &&
                    peopleWhoTrustExpectTownJudge.contains(expectTownJudge).not()
            ) {
                return expectTownJudge
            }
            return -1
        }
    }
}
