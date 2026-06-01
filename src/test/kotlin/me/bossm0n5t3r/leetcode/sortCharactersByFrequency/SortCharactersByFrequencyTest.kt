package me.bossm0n5t3r.leetcode.sortCharactersByFrequency

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SortCharactersByFrequencyTest {
    private val sut = SortCharactersByFrequency.Solution()

    private data class TestData(val s: String, val result: String)

    @Test
    fun test() {
        val tests =
            listOf(TestData("tree", "eert"), TestData("cccaaa", "aaaccc"), TestData("Aabb", "bbAa"))

        tests.forEach { test -> assertEquals(test.result, sut.frequencySort(test.s)) }
    }
}
