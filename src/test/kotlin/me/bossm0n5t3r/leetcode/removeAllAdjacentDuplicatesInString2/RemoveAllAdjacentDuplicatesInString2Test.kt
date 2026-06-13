package me.bossm0n5t3r.leetcode.removeAllAdjacentDuplicatesInString2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RemoveAllAdjacentDuplicatesInString2Test {
    private val removeAllAdjacentDuplicatesInString2 =
        RemoveAllAdjacentDuplicatesInString2.Solution()

    private data class RemoveAllAdjacentDuplicatesInString2TestData(
        val s: String,
        val k: Int,
        val result: String,
    )

    @Test
    fun removeDuplicates() {
        val tests =
            listOf(
                RemoveAllAdjacentDuplicatesInString2TestData("abcd", 2, "abcd"),
                RemoveAllAdjacentDuplicatesInString2TestData("deeedbbcccbdaa", 3, "aa"),
                RemoveAllAdjacentDuplicatesInString2TestData("pbbcggttciiippooaais", 2, "ps"),
                RemoveAllAdjacentDuplicatesInString2TestData(
                    "iiiixxxxxiiccccczzffffflllllllllfffffllyyyyyuuuuuz",
                    5,
                    "izzlz",
                ),
            )
        tests.forEach { test ->
            val result = removeAllAdjacentDuplicatesInString2.removeDuplicates(test.s, test.k)
            assertEquals(test.result, result)
        }
    }
}
