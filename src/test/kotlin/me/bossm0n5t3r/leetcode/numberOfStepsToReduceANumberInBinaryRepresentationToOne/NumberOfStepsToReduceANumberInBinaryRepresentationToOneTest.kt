package me.bossm0n5t3r.leetcode.numberOfStepsToReduceANumberInBinaryRepresentationToOne

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfStepsToReduceANumberInBinaryRepresentationToOneTest {
    private val sut = NumberOfStepsToReduceANumberInBinaryRepresentationToOne.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("1101", 6),
                TestData("10", 1),
                TestData("1", 0),
                TestData("1111011110000011100000110001011011110010111001010111110001", 85),
                TestData("1111110011101010110011100100101110010100101110111010111110110010", 89),
            )

        tests.forEach { test -> assertEquals(test.result, sut.numSteps(test.s)) }
    }
}
