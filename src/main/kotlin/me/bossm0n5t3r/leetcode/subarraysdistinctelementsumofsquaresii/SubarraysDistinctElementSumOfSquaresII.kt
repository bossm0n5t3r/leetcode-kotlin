package me.bossm0n5t3r.leetcode.subarraysdistinctelementsumofsquaresii

class SubarraysDistinctElementSumOfSquaresII {
    class Solution {
        companion object {
            private const val MOD = 1_000_000_007
        }

        private data class Node(var sum: Long = 0L, var squareSum: Long = 0L, var lazy: Long = 0L)

        private class SegmentTree(n: Int) {
            private val tree = Array(4 * n) { Node() }

            val squareSum: Long
                get() = tree[1].squareSum

            private fun apply(nodeIndex: Int, length: Int, add: Long) {
                val node = tree[nodeIndex]

                // 기존 sum으로 squareSum부터 계산해야 함
                val oldSum = node.sum
                // (d + add)^2 = d^2 + 2*add*d + add^2
                node.squareSum = (node.squareSum + 2 * add * oldSum + add * add * length) % MOD

                node.sum = (oldSum + add * length) % MOD

                // 자식들에게 아직 전달하지 않은 증가량
                node.lazy += add
            }

            private fun pushDown(nodeIndex: Int, left: Int, right: Int) {
                val node = tree[nodeIndex]

                if (node.lazy == 0L) return
                if (left == right) return

                val mid = (left + right) / 2

                val leftChild = nodeIndex * 2
                val rightChild = nodeIndex * 2 + 1

                val leftLength = mid - left + 1
                val rightLength = right - mid

                apply(leftChild, leftLength, node.lazy)
                apply(rightChild, rightLength, node.lazy)

                node.lazy = 0
            }

            fun rangeAdd(
                nodeIndex: Int,
                left: Int,
                right: Int,
                queryLeft: Int,
                queryRight: Int,
                add: Long,
            ) {
                // 구간이 전혀 겹치지 않음
                if (right < queryLeft || queryRight < left) return

                // 현재 노드 구간 전체가 업데이트 범위에 포함됨
                if (queryLeft <= left && right <= queryRight) {
                    apply(nodeIndex, right - left + 1, add)
                    return
                }

                // 부분적으로 겹치므로 자식으로 내려감
                pushDown(nodeIndex, left, right)

                val mid = (left + right) / 2

                rangeAdd(nodeIndex * 2, left, mid, queryLeft, queryRight, add)

                rangeAdd(nodeIndex * 2 + 1, mid + 1, right, queryLeft, queryRight, add)

                // 두 자식의 결과를 부모에 반영
                tree[nodeIndex].sum = (tree[nodeIndex * 2].sum + tree[nodeIndex * 2 + 1].sum) % MOD

                tree[nodeIndex].squareSum =
                    (tree[nodeIndex * 2].squareSum + tree[nodeIndex * 2 + 1].squareSum) % MOD
            }
        }

        fun sumCounts(nums: IntArray): Int {
            val n = nums.size
            val segmentTree = SegmentTree(n)

            // 각 숫자의 마지막 등장 위치
            val last = mutableMapOf<Int, Int>()

            var answer = 0L

            for (right in nums.indices) {
                val value = nums[right]
                val previousIndex = last.getOrDefault(value, -1)

                // 새로운 value로 인해 distinct count가 +1 되는 구간
                val updateLeft = previousIndex + 1

                segmentTree.rangeAdd(
                    nodeIndex = 1,
                    left = 0,
                    right = n - 1,
                    queryLeft = updateLeft,
                    queryRight = right,
                    add = 1L,
                )

                // 현재 right에서 끝나는 모든 subarray의 distinct² 합
                answer = (answer + segmentTree.squareSum) % MOD

                last[value] = right
            }

            return answer.toInt()
        }
    }
}
