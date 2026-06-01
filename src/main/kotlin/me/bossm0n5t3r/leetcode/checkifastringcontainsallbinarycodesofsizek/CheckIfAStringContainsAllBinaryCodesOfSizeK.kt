package me.bossm0n5t3r.leetcode.checkifastringcontainsallbinarycodesofsizek

class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    class Solution {
        fun hasAllCodes(s: String, k: Int): Boolean {
            val totalNeeded = 1 shl k
            val seen = BooleanArray(totalNeeded)
            var count = 0

            if (s.length < k) return false

            var hash = 0
            val mask = totalNeeded - 1 // k비트만큼만 유지하기 위한 마스크

            for (i in s.indices) {
                // 슬라이딩 윈도우 방식으로 현재 비트 값 갱신
                hash = ((hash shl 1) or (s[i] - '0')) and mask

                // 처음 k글자가 채워진 시점부터 체크 시작
                if (i >= k - 1) {
                    if (!seen[hash]) {
                        seen[hash] = true
                        count++
                        if (count == totalNeeded) return true
                    }
                }
            }
            return false
        }
    }
}
