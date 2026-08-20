package me.bossm0n5t3r.leetcode.distributeelementsintotwoarraysii

class DistributeElementsIntoTwoArraysII {
    class Solution {
        fun resultArray(nums: IntArray): IntArray {
            // 1. Coordinate Compression
            val sorted = nums.distinct().sorted()
            val rankMap = HashMap<Int, Int>(sorted.size)

            for (i in sorted.indices) {
                rankMap[sorted[i]] = i + 1 // Fenwick Tree 는 1-based
            }

            // 2. 각 배열의 값 분포를 관리하는 Fenwick Tree
            val tree1 = FenwickTree(sorted.size)
            val tree2 = FenwickTree(sorted.size)

            // 3. 실제 insertion order 를 보존할 배열
            val arr1 = ArrayList<Int>()
            val arr2 = ArrayList<Int>()

            for (num in nums) {
                val rank = rankMap.getValue(num)

                when {
                    arr1.isEmpty() -> {
                        arr1.add(num)
                        tree1.add(rank, 1)
                    }

                    arr2.isEmpty() -> {
                        arr2.add(num)
                        tree2.add(rank, 1)
                    }

                    else -> {
                        // num 보다 큰 값의 개수
                        val greater1 = arr1.size - tree1.prefixSum(rank)
                        val greater2 = arr2.size - tree2.prefixSum(rank)

                        if (
                            greater1 > greater2 || (greater1 == greater2 && arr1.size <= arr2.size)
                        ) {
                            arr1.add(num)
                            tree1.add(rank, 1)
                        } else {
                            arr2.add(num)
                            tree2.add(rank, 1)
                        }
                    }
                }
            }

            return IntArray(nums.size).also { result ->
                var index = 0

                for (num in arr1) {
                    result[index++] = num
                }

                for (num in arr2) {
                    result[index++] = num
                }
            }
        }

        private class FenwickTree(size: Int) {
            private val tree = IntArray(size + 1)

            fun add(index: Int, value: Int) {
                var i = index

                while (i < tree.size) {
                    tree[i] += value
                    i += i and -i
                }
            }

            fun prefixSum(index: Int): Int {
                var i = index
                var sum = 0

                while (i > 0) {
                    sum += tree[i]
                    i -= i and -i
                }

                return sum
            }
        }
    }
}
