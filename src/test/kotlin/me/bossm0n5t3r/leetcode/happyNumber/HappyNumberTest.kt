package me.bossm0n5t3r.leetcode.happyNumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HappyNumberTest {
    private val happyNumber = HappyNumber.Solution()

    data class HappyNumberTestData(val n: Int, val result: Boolean)

    @Test
    fun isHappy() {
        val tests = listOf(HappyNumberTestData(19, true), HappyNumberTestData(2, false))
        tests.forEach { test -> assertEquals(happyNumber.isHappy(test.n), test.result) }
    }
}
