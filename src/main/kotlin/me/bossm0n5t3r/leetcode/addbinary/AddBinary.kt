package me.bossm0n5t3r.leetcode.addbinary

class AddBinary {
    class Solution {
        fun addBinary(a: String, b: String): String {
            val sb = StringBuilder()
            var i = a.length - 1
            var j = b.length - 1
            var carry = 0
            while (i >= 0 || j >= 0) {
                val sum =
                    carry + (if (i >= 0) a[i--] - '0' else 0) + (if (j >= 0) b[j--] - '0' else 0)
                sb.append(sum % 2)
                carry = sum / 2
            }
            if (carry != 0) sb.append(carry)
            return sb.reverse().toString()
        }
    }
}
