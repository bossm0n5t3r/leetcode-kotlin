package me.bossm0n5t3r.leetcode.minStack

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinStackTest {
    private lateinit var minStack: MinStack

    data class MinStackTestData(
        val input: Pair<List<String>, List<List<Int>>>,
        val output: List<Int?>,
    )

    @Test
    fun test() {
        val tests =
            listOf(
                MinStackTestData(
                    input =
                        Pair(
                            listOf(
                                "MinStack",
                                "push",
                                "push",
                                "push",
                                "getMin",
                                "pop",
                                "top",
                                "getMin",
                            ),
                            listOf(
                                listOf(),
                                listOf(-2),
                                listOf(0),
                                listOf(-3),
                                listOf(),
                                listOf(),
                                listOf(),
                                listOf(),
                            ),
                        ),
                    output = listOf(null, null, null, null, -3, null, 0, -2),
                ),
                MinStackTestData(
                    input =
                        Pair(
                            listOf(
                                "MinStack",
                                "push",
                                "push",
                                "push",
                                "top",
                                "pop",
                                "getMin",
                                "pop",
                                "getMin",
                                "pop",
                                "push",
                                "top",
                                "getMin",
                                "push",
                                "top",
                                "getMin",
                                "pop",
                                "getMin",
                            ),
                            listOf(
                                listOf(),
                                listOf(2147483646),
                                listOf(2147483646),
                                listOf(2147483647),
                                listOf(),
                                listOf(),
                                listOf(),
                                listOf(),
                                listOf(),
                                listOf(),
                                listOf(2147483647),
                                listOf(),
                                listOf(),
                                listOf(-2147483648),
                                listOf(),
                                listOf(),
                                listOf(),
                                listOf(),
                            ),
                        ),
                    output =
                        listOf(
                            null,
                            null,
                            null,
                            null,
                            2147483647,
                            null,
                            2147483646,
                            null,
                            2147483646,
                            null,
                            null,
                            2147483647,
                            2147483647,
                            null,
                            -2147483648,
                            -2147483648,
                            null,
                            2147483647,
                        ),
                ),
            )
        tests.forEach { test ->
            val (commandList, inputData) = test.input
            val outputData = test.output
            commandList.forEachIndexed { index, command ->
                when (command) {
                    "MinStack" -> {
                        minStack = MinStack()
                    }

                    "push" -> {
                        minStack.push(inputData[index].first())
                    }

                    "pop" -> {
                        minStack.pop()
                    }

                    "top" -> {
                        assertEquals(outputData[index], minStack.top())
                    }

                    "getMin" -> {
                        assertEquals(outputData[index], minStack.getMin())
                    }
                }
            }
        }
    }
}
