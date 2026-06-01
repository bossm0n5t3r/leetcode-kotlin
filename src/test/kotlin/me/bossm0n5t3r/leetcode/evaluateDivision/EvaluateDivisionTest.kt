package me.bossm0n5t3r.leetcode.evaluateDivision

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EvaluateDivisionTest {
    private val sut = EvaluateDivision.Solution()

    private data class TestData(
        val equations: List<List<String>>,
        val values: DoubleArray,
        val queries: List<List<String>>,
        val result: DoubleArray,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (equations != other.equations) return false
            if (!values.contentEquals(other.values)) return false
            if (queries != other.queries) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = equations.hashCode()
            result1 = 31 * result1 + values.contentHashCode()
            result1 = 31 * result1 + queries.hashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Suppress("LongMethod")
    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    equations = listOf(listOf("a", "b"), listOf("b", "c")),
                    values = doubleArrayOf(2.0, 3.0),
                    queries =
                        listOf(
                            listOf("a", "c"),
                            listOf("b", "a"),
                            listOf("a", "e"),
                            listOf("a", "a"),
                            listOf("x", "x"),
                        ),
                    result = doubleArrayOf(6.00000, 0.50000, -1.00000, 1.00000, -1.00000),
                ),
                TestData(
                    equations = listOf(listOf("a", "b"), listOf("b", "c"), listOf("bc", "cd")),
                    values = doubleArrayOf(1.5, 2.5, 5.0),
                    queries =
                        listOf(
                            listOf("a", "c"),
                            listOf("c", "b"),
                            listOf("bc", "cd"),
                            listOf("cd", "bc"),
                        ),
                    result = doubleArrayOf(3.75000, 0.40000, 5.00000, 0.20000),
                ),
                TestData(
                    equations = listOf(listOf("a", "b")),
                    values = doubleArrayOf(0.5),
                    queries =
                        listOf(
                            listOf("a", "b"),
                            listOf("b", "a"),
                            listOf("a", "c"),
                            listOf("x", "y"),
                        ),
                    result = doubleArrayOf(0.50000, 2.00000, -1.00000, -1.00000),
                ),
                TestData(
                    equations = listOf(listOf("a", "e"), listOf("b", "e")),
                    values = doubleArrayOf(4.0, 3.0),
                    queries = listOf(listOf("a", "b"), listOf("e", "e"), listOf("x", "x")),
                    result = doubleArrayOf(1.3333333333333333, 1.00000, -1.00000),
                ),
            )

        tests.forEach { test ->
            assertThat(sut.calcEquation(test.equations, test.values, test.queries))
                .isEqualTo(test.result)
        }
    }
}
