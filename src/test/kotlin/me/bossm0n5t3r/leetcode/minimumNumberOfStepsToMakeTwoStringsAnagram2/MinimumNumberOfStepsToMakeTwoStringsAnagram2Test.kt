package me.bossm0n5t3r.leetcode.minimumNumberOfStepsToMakeTwoStringsAnagram2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MinimumNumberOfStepsToMakeTwoStringsAnagram2Test {
    private val minimumNumberOfStepsToMakeTwoStringsAnagram2 =
        MinimumNumberOfStepsToMakeTwoStringsAnagram2.Solution()

    private data class MinimumNumberOfStepsToMakeTwoStringsAnagram2TestData(
        val s: String,
        val t: String,
        val result: Int,
    )

    @Test
    fun minSteps() {
        val tests =
            listOf(
                MinimumNumberOfStepsToMakeTwoStringsAnagram2TestData("leetcode", "coats", 7),
                MinimumNumberOfStepsToMakeTwoStringsAnagram2TestData("night", "thing", 0),
            )
        tests.forEach { test ->
            val result = minimumNumberOfStepsToMakeTwoStringsAnagram2.minSteps(test.s, test.t)
            println(result)
            assertEquals(result, test.result)
        }
    }
}
