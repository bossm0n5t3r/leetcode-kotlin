package me.bossm0n5t3r.leetcode.rectangleoverlap

class RectangleOverlap {
    class Solution {
        fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
            return !(rec1[2] <= rec2[0] || // rec1이 rec2의 왼쪽
                rec2[2] <= rec1[0] || // rec2가 rec1의 왼쪽
                rec1[3] <= rec2[1] || // rec1이 rec2의 아래
                rec2[3] <= rec1[1] // rec2가 rec1의 아래
            )
        }
    }
}
