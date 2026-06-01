package me.bossm0n5t3r.leetcode.productofthelastknumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProductOfTheLastKNumbersTest {
    @Test
    fun test() {
        val sut = ProductOfTheLastKNumbers.ProductOfNumbers()

        sut.add(3) // [3]
        sut.add(0) // [3,0]
        sut.add(2) // [3,0,2]
        sut.add(5) // [3,0,2,5]
        sut.add(4) // [3,0,2,5,4]
        assertEquals(
            20,
            sut.getProduct(2),
        ) // return 20. The product of the last 2 numbers is 5 * 4 = 20
        assertEquals(
            40,
            sut.getProduct(3),
        ) // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
        assertEquals(
            0,
            sut.getProduct(4),
        ) // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
        sut.add(8) // [3,0,2,5,4,8]
        assertEquals(
            32,
            sut.getProduct(2),
        ) // return 32. The product of the last 2 numbers is 4 * 8 = 32
    }
}
