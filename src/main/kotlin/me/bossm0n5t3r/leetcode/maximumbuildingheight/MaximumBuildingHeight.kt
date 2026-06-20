package me.bossm0n5t3r.leetcode.maximumbuildingheight

class MaximumBuildingHeight {
    class Solution {
        fun maxBuilding(n: Int, restrictions: Array<IntArray>): Int {
            val sortedRestrictions =
                (listOf(intArrayOf(1, 0), intArrayOf(n, n - 1)) + restrictions.map { it.copyOf() })
                    .sortedBy { it.first() }
            var maxHeight = 0
            for (i in 1..sortedRestrictions.lastIndex) {
                val curBuilding = sortedRestrictions[i]
                val prevBuilding = sortedRestrictions[i - 1]
                curBuilding[1] =
                    minOf(
                        curBuilding.last(),
                        prevBuilding.last() + (curBuilding.first() - prevBuilding.first()),
                    )
            }
            for (i in sortedRestrictions.lastIndex downTo 1) {
                val curBuilding = sortedRestrictions[i]
                val prevBuilding = sortedRestrictions[i - 1]
                prevBuilding[1] =
                    minOf(
                        prevBuilding.last(),
                        curBuilding.last() + (curBuilding.first() - prevBuilding.first()),
                    )
            }
            for (i in 1..sortedRestrictions.lastIndex) {
                val curBuilding = sortedRestrictions[i]
                val prevBuilding = sortedRestrictions[i - 1]
                val distance = curBuilding.first() - prevBuilding.first()
                maxHeight =
                    maxOf(maxHeight, (prevBuilding.last() + curBuilding.last() + distance) / 2)
            }
            return maxHeight
        }
    }
}
