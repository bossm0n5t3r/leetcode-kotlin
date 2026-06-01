package me.bossm0n5t3r.leetcode.maximizeTheConfusionOfAnExam

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeTheConfusionOfAnExamTest {
    private val sut = MaximizeTheConfusionOfAnExam.Solution()

    private data class TestData(val answerKey: String, val k: Int, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(answerKey = "TTFF", k = 2, result = 4),
                TestData(answerKey = "TFFT", k = 1, result = 3),
                TestData(answerKey = "TTFTTFTT", k = 1, result = 5),
            )

        tests.forEach { test ->
            assertEquals(sut.maxConsecutiveAnswers(test.answerKey, test.k), test.result)
        }
    }
}
