package me.bossm0n5t3r.leetcode.searchInABinarySearchTree

import me.bossm0n5t3r.leetcode.utils.TreeNode

class SearchInABinarySearchTree {
    class Solution {
        fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
            var tmp = root
            while (tmp != null && tmp.`val` != `val`) {
                tmp =
                    if (tmp.`val` > `val`) {
                        tmp.left
                    } else {
                        tmp.right
                    }
            }
            return tmp
        }
    }
}
