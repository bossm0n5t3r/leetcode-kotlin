package me.bossm0n5t3r.leetcode.backspaceStringCompare

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BackspaceStringCompareTest {
    private val backspaceStringCompare = BackspaceStringCompare.Solution()

    private data class BackspaceStringCompareTest(val s: String, val t: String, val result: Boolean)

    @Test
    fun backspaceCompare() {
        val tests =
            listOf(
                BackspaceStringCompareTest("ab#c", "ad#c", true),
                BackspaceStringCompareTest("ab##", "c#d#", true),
                BackspaceStringCompareTest("a#c", "b", false),
            )
        tests.forEach { test ->
            val result = backspaceStringCompare.backspaceCompare(test.s, test.t)
            println(result)
            assertEquals(result, test.result)

            val resultWithRestriction =
                backspaceStringCompare.backspaceCompareWithRestriction(test.s, test.t)
            println(resultWithRestriction)
            assertEquals(resultWithRestriction, test.result)
        }
    }
}
