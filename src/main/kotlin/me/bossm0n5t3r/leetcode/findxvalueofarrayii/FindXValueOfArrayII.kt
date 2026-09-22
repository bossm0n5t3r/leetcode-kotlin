package me.bossm0n5t3r.leetcode.findxvalueofarrayii

class FindXValueOfArrayII {
    class Solution {
        fun resultArray(nums: IntArray, k: Int, queries: Array<IntArray>): IntArray {
            val segmentTree = SegmentTree(nums, k)
            val result = IntArray(queries.size)

            for (i in queries.indices) {
                val (index, value, start, x) = queries[i]

                // 이 update는 이후 query에도 계속 유지됨
                segmentTree.update(index, value)

                // nums[start..n-1]에서
                // start부터 시작하는 prefix product 중
                // product % k == x 인 개수
                val node = segmentTree.query(start, nums.lastIndex)
                result[i] = node.remainderCount[x]
            }

            return result
        }

        private class SegmentTree(nums: IntArray, private val k: Int) {
            private val n = nums.size
            private val tree = arrayOfNulls<Node>(n * 4)

            init {
                build(nums, 1, 0, n - 1)
            }

            fun update(index: Int, value: Int) {
                update(treeIndex = 1, left = 0, right = n - 1, index = index, value = value % k)
            }

            fun query(queryLeft: Int, queryRight: Int): Node {
                return query(
                    treeIndex = 1,
                    left = 0,
                    right = n - 1,
                    queryLeft = queryLeft,
                    queryRight = queryRight,
                )
            }

            private fun build(nums: IntArray, treeIndex: Int, left: Int, right: Int) {
                if (left == right) {
                    tree[treeIndex] = createLeaf(nums[left] % k)
                    return
                }

                val mid = left + (right - left) / 2

                build(nums, treeIndex * 2, left, mid)
                build(nums, treeIndex * 2 + 1, mid + 1, right)

                tree[treeIndex] =
                    merge(
                        requireNotNull(tree[treeIndex * 2]),
                        requireNotNull(tree[treeIndex * 2 + 1]),
                    )
            }

            private fun update(treeIndex: Int, left: Int, right: Int, index: Int, value: Int) {
                if (left == right) {
                    tree[treeIndex] = createLeaf(value)
                    return
                }

                val mid = left + (right - left) / 2

                if (index <= mid) {
                    update(treeIndex * 2, left, mid, index, value)
                } else {
                    update(treeIndex * 2 + 1, mid + 1, right, index, value)
                }

                tree[treeIndex] =
                    merge(
                        requireNotNull(tree[treeIndex * 2]),
                        requireNotNull(tree[treeIndex * 2 + 1]),
                    )
            }

            private fun query(
                treeIndex: Int,
                left: Int,
                right: Int,
                queryLeft: Int,
                queryRight: Int,
            ): Node {
                if (queryLeft <= left && right <= queryRight) {
                    return requireNotNull(tree[treeIndex])
                }

                if (right < queryLeft || queryRight < left) {
                    // merge의 항등원
                    return Node(product = 1 % k, remainderCount = IntArray(k))
                }

                val mid = left + (right - left) / 2

                val leftNode = query(treeIndex * 2, left, mid, queryLeft, queryRight)

                val rightNode = query(treeIndex * 2 + 1, mid + 1, right, queryLeft, queryRight)

                return merge(leftNode, rightNode)
            }

            private fun createLeaf(value: Int): Node {
                val remainderCount = IntArray(k)

                // 원소 하나짜리 구간의 prefix는 자기 자신 하나
                remainderCount[value] = 1

                return Node(product = value, remainderCount = remainderCount)
            }

            private fun merge(left: Node, right: Node): Node {
                val remainderCount = left.remainderCount.copyOf()

                /*
                 * [left][right]를 합친다고 생각하면:
                 *
                 * 1. left 내부에서 끝나는 prefix
                 *    → 그대로 left.remainderCount
                 *
                 * 2. right까지 넘어가는 prefix
                 *    → left 전체를 반드시 전부 곱한 다음
                 *      right의 prefix를 붙여야 함
                 *
                 * 예:
                 *
                 * left  = [2, 3]
                 * right = [4, 5]
                 *
                 * 전체 구간의 prefix:
                 * [2]
                 * [2,3]
                 * [2,3,4]
                 * [2,3,4,5]
                 *
                 * right 쪽 prefix [4]를 사용할 때는
                 * 그냥 4가 아니라
                 *
                 * product(left) * 4
                 *
                 * 가 되는 것.
                 */
                for (rightRemainder in 0 until k) {
                    val count = right.remainderCount[rightRemainder]
                    if (count == 0) continue

                    val mergedRemainder = (left.product * rightRemainder) % k

                    remainderCount[mergedRemainder] += count
                }

                return Node(
                    product = (left.product * right.product) % k,
                    remainderCount = remainderCount,
                )
            }
        }

        private class Node(
            // 이 구간 전체 원소의 product % k
            val product: Int,

            // 이 구간의 왼쪽 끝에서 시작하는 모든 prefix 중
            // product % k == r 인 prefix가 몇 개인지
            val remainderCount: IntArray,
        )
    }
}
