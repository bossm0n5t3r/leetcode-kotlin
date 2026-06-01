package me.bossm0n5t3r.leetcode.implementrouter

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ImplementRouterTest {
    @Test
    fun test0() {
        val router = ImplementRouter.Router(3)
        assertEquals(true, router.addPacket(1, 4, 90))
        assertEquals(true, router.addPacket(2, 5, 90))
        assertEquals(false, router.addPacket(1, 4, 90))
        assertEquals(true, router.addPacket(3, 5, 95))
        assertEquals(true, router.addPacket(4, 5, 105))
        assertTrue { intArrayOf(2, 5, 90).contentEquals(router.forwardPacket()) }
        assertEquals(true, router.addPacket(5, 2, 110))
        assertEquals(1, router.getCount(5, 100, 110))
    }

    @Test
    fun test1() {
        val router = ImplementRouter.Router(2)
        assertEquals(true, router.addPacket(7, 4, 90))
        assertTrue { intArrayOf(7, 4, 90).contentEquals(router.forwardPacket()) }
        assertTrue { intArrayOf().contentEquals(router.forwardPacket()) }
    }

    @Test
    fun test2() {
        val router = ImplementRouter.Router(4)
        assertEquals(true, router.addPacket(4, 5, 1))
        assertEquals(1, router.getCount(5, 1, 1))
    }
}
