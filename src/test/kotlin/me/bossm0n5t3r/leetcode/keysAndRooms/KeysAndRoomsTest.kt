package me.bossm0n5t3r.leetcode.keysAndRooms

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KeysAndRoomsTest {
    private val sut = KeysAndRooms.Solution()

    private data class TestData(val rooms: List<List<Int>>, val result: Boolean)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    rooms = listOf(listOf(1), listOf(2), listOf(3), emptyList()),
                    result = true,
                ),
                TestData(
                    rooms = listOf(listOf(1, 3), listOf(3, 0, 1), listOf(2), listOf(0)),
                    result = false,
                ),
            )

        tests.forEach { test -> assertEquals(sut.canVisitAllRooms(test.rooms), test.result) }
    }
}
