package me.bossm0n5t3r.leetcode.sumofroottoleafbinarynumbers

import me.bossm0n5t3r.leetcode.utils.TreeNode

class SumOfRootToLeafBinaryNumbers {
    class Solution {
        fun sumRootToLeaf(root: TreeNode?): Int = calculateSum(root, 0)

        private fun calculateSum(node: TreeNode?, currentSum: Int): Int {
            if (node == null) return 0

            // 현재까지의 합에 2를 곱하고(비트 시프트) 현재 노드 값을 더함
            val newSum = (currentSum shl 1) or node.`val`

            // 리프 노드(자식이 없는 노드)에 도달했을 때 현재까지 완성된 값을 반환
            if (node.left == null && node.right == null) {
                return newSum
            }

            // 좌우 자식 노드로 내려가며 합산
            return calculateSum(node.left, newSum) + calculateSum(node.right, newSum)
        }
    }
}
