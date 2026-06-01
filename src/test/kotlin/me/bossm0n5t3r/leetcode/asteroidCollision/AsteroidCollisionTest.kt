package me.bossm0n5t3r.leetcode.asteroidCollision

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AsteroidCollisionTest {
    private val sut = AsteroidCollision.Solution()

    private data class TestData(val asteroids: IntArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!asteroids.contentEquals(other.asteroids)) return false
            return result.contentEquals(other.result)
        }

        override fun hashCode(): Int {
            var result1 = asteroids.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(asteroids = intArrayOf(5, 10, -5), result = intArrayOf(5, 10)),
                TestData(asteroids = intArrayOf(8, -8), result = intArrayOf()),
                TestData(asteroids = intArrayOf(10, 2, -5), result = intArrayOf(10)),
                TestData(asteroids = intArrayOf(-2, -2, 1, -2), result = intArrayOf(-2, -2, -2)),
                TestData(asteroids = intArrayOf(-2, -2, 1, -1), result = intArrayOf(-2, -2)),
                TestData(asteroids = intArrayOf(1, -2, -2, -2), result = intArrayOf(-2, -2, -2)),
            )

        tests.forEach { test ->
            assertThat(sut.asteroidCollision(test.asteroids))
                .containsExactly(test.result.toTypedArray())
        }
    }
}
