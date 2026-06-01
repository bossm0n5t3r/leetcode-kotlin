package me.bossm0n5t3r.leetcode.implementrouter

class ImplementRouter {
    class Router(private val memoryLimit: Int) {
        private data class Packet(val source: Int, val destination: Int, val timestamp: Int) {
            fun toIntArray(): IntArray = intArrayOf(source, destination, timestamp)
        }

        private val memory = ArrayDeque<Packet>()
        private val packetSet = mutableSetOf<Packet>()
        private val memoryMap = mutableMapOf<Int, ArrayDeque<Int>>()

        private fun removeOldestPacket(): Pair<Boolean, IntArray> {
            if (memory.isEmpty()) {
                return false to intArrayOf()
            }
            val oldestPacket = memory.removeFirst()
            packetSet.remove(oldestPacket)
            memoryMap[oldestPacket.destination]?.removeFirst()
            return true to oldestPacket.toIntArray()
        }

        private fun binarySearch(list: List<Int>, target: Int, includeEqual: Boolean = false): Int {
            var left = 0
            var right = list.size
            while (left < right) {
                val m = left + (right - left) / 2
                if (
                    (includeEqual.not() && list[m] < target) || (includeEqual && list[m] <= target)
                ) {
                    left = m + 1
                } else {
                    right = m
                }
            }
            return left
        }

        fun addPacket(source: Int, destination: Int, timestamp: Int): Boolean {
            val newPacket = Packet(source, destination, timestamp)
            if (packetSet.contains(newPacket)) {
                return false
            }
            if (memory.size >= memoryLimit) {
                removeOldestPacket()
            }
            memory.add(newPacket)
            packetSet += newPacket
            memoryMap.computeIfAbsent(destination) { ArrayDeque() }.add(timestamp)
            return true
        }

        fun forwardPacket(): IntArray = removeOldestPacket().second

        fun getCount(destination: Int, startTime: Int, endTime: Int): Int {
            val timestamps = memoryMap[destination] ?: return 0
            val firstPacket = binarySearch(timestamps, startTime)
            val lastPacket = binarySearch(timestamps, endTime, true)
            return lastPacket - firstPacket
        }
    }
}
