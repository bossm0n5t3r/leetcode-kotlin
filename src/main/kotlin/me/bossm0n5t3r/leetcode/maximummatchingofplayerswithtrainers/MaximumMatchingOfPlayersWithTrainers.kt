package me.bossm0n5t3r.leetcode.maximummatchingofplayerswithtrainers

class MaximumMatchingOfPlayersWithTrainers {
    class Solution {
        fun matchPlayersAndTrainers(players: IntArray, trainers: IntArray): Int {
            players.sortDescending()
            trainers.sortDescending()

            var playerIndex = 0
            var trainerIndex = 0
            var count = 0

            while (playerIndex < players.size) {
                if (trainerIndex == trainers.size) break
                val currentPlayer = players[playerIndex++]
                if (trainers[trainerIndex] < currentPlayer) continue
                trainerIndex++
                count++
            }

            return count
        }
    }
}
