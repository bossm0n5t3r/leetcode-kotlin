package me.bossm0n5t3r.leetcode.fillingBookcaseShelves

class FillingBookcaseShelves {
    class Solution {
        fun minHeightShelves(books: Array<IntArray>, shelfWidth: Int): Int {
            val dp = IntArray(books.size + 1)
            for ((index, book) in books.withIndex()) {
                var (width, height) = book
                dp[index + 1] = dp[index] + height
                for (j in index - 1 downTo 0) {
                    width += books[j][0]
                    if (width > shelfWidth) {
                        break
                    }
                    height = maxOf(height, books[j][1])
                    dp[index + 1] = minOf(dp[index + 1], dp[j] + height)
                }
            }
            return dp[books.size]
        }
    }
}
