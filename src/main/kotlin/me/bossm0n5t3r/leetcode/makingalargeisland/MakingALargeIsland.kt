package me.bossm0n5t3r.leetcode.makingalargeisland

class MakingALargeIsland {
    class Solution {
        fun largestIsland(grid: Array<IntArray>): Int {
            val (m, n) = grid.size to grid[0].size
            val islandIdToIslandSize = mutableMapOf<Int, Int>()
            var islandId = 2

            // Step 1: Mark all islands and calculate their sizes
            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (grid[r][c] == 1) {
                        islandIdToIslandSize[islandId] = exploreIsland(grid, islandId, r, c)
                        ++islandId
                    }
                }
            }

            // If there are no islands, return 1
            if (islandIdToIslandSize.isEmpty()) {
                return 1
            }

            // If the entire grid is one island, return its size or size + 1
            if (islandIdToIslandSize.size == 1) {
                --islandId
                val islandSize = islandIdToIslandSize[islandId] ?: error("Island size not found")
                return if (islandSize == m * n) islandSize else islandSize + 1
            }

            var maxIslandSize = 1

            // Step 2: Try converting every 0 to 1 and calculate the resulting island size
            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (grid[r][c] == 0) {
                        val neighboringIslands = mutableSetOf<Int>()

                        // Check down
                        if (r + 1 < grid.size && grid[r + 1][c] > 1) {
                            neighboringIslands.add(grid[r + 1][c])
                        }

                        // Check up
                        if (r - 1 >= 0 && grid[r - 1][c] > 1) {
                            neighboringIslands.add(grid[r - 1][c])
                        }

                        // Check right
                        if (c + 1 < grid[0].size && grid[r][c + 1] > 1) {
                            neighboringIslands.add(grid[r][c + 1])
                        }

                        // Check left
                        if (c - 1 >= 0 && grid[r][c - 1] > 1) {
                            neighboringIslands.add(grid[r][c - 1])
                        }

                        // Sum the sizes of all unique neighboring islands
                        val currentIslandSize =
                            1 + neighboringIslands.mapNotNull { islandIdToIslandSize[it] }.sum()

                        maxIslandSize = maxOf(maxIslandSize, currentIslandSize)
                    }
                }
            }

            return maxIslandSize
        }

        private fun exploreIsland(
            grid: Array<IntArray>,
            islandId: Int,
            currentRow: Int,
            currentColumn: Int,
        ): Int {
            if (
                currentRow < 0 ||
                    currentRow >= grid.size ||
                    currentColumn < 0 ||
                    currentColumn >= grid[0].size ||
                    grid[currentRow][currentColumn] != 1
            ) {
                return 0
            }

            grid[currentRow][currentColumn] = islandId
            return (1 +
                exploreIsland(grid, islandId, currentRow + 1, currentColumn) +
                exploreIsland(grid, islandId, currentRow - 1, currentColumn) +
                exploreIsland(grid, islandId, currentRow, currentColumn + 1) +
                exploreIsland(grid, islandId, currentRow, currentColumn - 1))
        }
    }
}
