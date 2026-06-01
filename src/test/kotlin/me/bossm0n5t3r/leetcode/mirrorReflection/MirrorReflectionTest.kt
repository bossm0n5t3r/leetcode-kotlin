package me.bossm0n5t3r.leetcode.mirrorReflection

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MirrorReflectionTest {
    private val sut = MirrorReflection.Solution()

    private data class Example(val p: Int, val q: Int, val result: Int)

    @Test
    fun mirrorReflection() {
        val tests = listOf(Example(2, 1, 2), Example(3, 1, 1))
        tests.forEach { test -> assertEquals(sut.mirrorReflection(test.p, test.q), test.result) }
    }
}
