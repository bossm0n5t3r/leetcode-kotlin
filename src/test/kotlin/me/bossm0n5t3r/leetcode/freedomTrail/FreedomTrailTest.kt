package me.bossm0n5t3r.leetcode.freedomTrail

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FreedomTrailTest {
    private val sut = FreedomTrail.Solution()

    private data class TestData(val ring: String, val key: String, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("godding", "gd", 4),
                TestData("godding", "godding", 13),
                TestData("nyngl", "yyynnnnnnlllggg", 19),
                TestData("cwqie", "qqwiciqwceecewi", 34),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.findRotateSteps(test.ring, test.key))
        }
    }
}
