package me.bossm0n5t3r.leetcode.numberOfRecentCalls

class NumberOfRecentCalls {
    /**
     * Implement the RecentCounter class:
     *
     *      RecentCounter() Initializes the counter with zero recent requests.
     *      int ping(int t) Adds a new request at time t, where t represents some time in milliseconds,
     *      and returns the number of requests that has happened in the past 3000 milliseconds
     *      (including the new request).
     *      Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
     *
     * It is guaranteed that every call to ping uses a strictly larger value of t than the previous
     * call.
     */
    class RecentCounter {
        companion object {
            private const val REQUEST_RANGE_MILLISECONDS = 3000
        }

        private val requests = mutableListOf<Int>()

        fun ping(t: Int): Int {
            requests.add(t)
            return requests.count { it >= t - REQUEST_RANGE_MILLISECONDS }
        }
    }
}
