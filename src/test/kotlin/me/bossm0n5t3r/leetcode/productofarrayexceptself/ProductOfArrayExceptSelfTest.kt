package me.bossm0n5t3r.leetcode.productofarrayexceptself

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProductOfArrayExceptSelfTest {
    private val productOfArrayExceptSelf = ProductOfArrayExceptSelf.Solution()

    private data class ProductOfArrayExceptSelfTestData(val nums: IntArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as ProductOfArrayExceptSelfTestData

            if (!nums.contentEquals(other.nums)) return false
            return result.contentEquals(other.result)
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun productExceptSelfTest() {
        val tests =
            listOf(
                ProductOfArrayExceptSelfTestData(intArrayOf(1, 2, 3, 4), intArrayOf(24, 12, 8, 6)),
                ProductOfArrayExceptSelfTestData(
                    intArrayOf(-1, 1, 0, -3, 3),
                    intArrayOf(0, 0, 9, 0, 0),
                ),
            )
        tests.forEach { test ->
            assertThat(test.result)
                .isEqualTo(productOfArrayExceptSelf.productExceptSelf(test.nums))
                .isEqualTo(productOfArrayExceptSelf.productExceptSelfAt20230707(test.nums))
                .isEqualTo(productOfArrayExceptSelf.productExceptSelfAt20250104(test.nums))
        }
    }
}
