package me.bossm0n5t3r.leetcode.minimummovestocleantheclassroom

class MinimumMovesToCleanTheClassroom {
    class Solution {
        data class Student(
            val r: Int,
            val c: Int,
            val mask: Int,
            val energy: Int,
            val distance: Int = 0,
        )

        fun minMoves(classroom: Array<String>, energy: Int): Int {
            val (m, n) = classroom.size to classroom.first().length

            val litterIndex = Array(m) { IntArray(n) { -1 } }

            var startR = 0
            var startC = 0
            var litterCount = 0

            for (r in 0 until m) {
                for (c in 0 until n) {
                    when (classroom[r][c]) {
                        'S' -> {
                            startR = r
                            startC = c
                        }

                        'L' -> {
                            litterIndex[r][c] = litterCount++
                        }
                    }
                }
            }

            val resultMask = (1 shl litterCount) - 1

            val queue = ArrayDeque<Student>()
            queue += Student(r = startR, c = startC, mask = 0, energy = energy)

            // 같은 (r, c, mask)에서 지금까지 도달한 최대 잔여 energy
            val maxEnergy = Array(m) { Array(n) { IntArray(1 shl litterCount) { -1 } } }

            maxEnergy[startR][startC][0] = energy

            val dr = intArrayOf(0, 0, 1, -1)
            val dc = intArrayOf(1, -1, 0, 0)

            while (queue.isNotEmpty()) {
                val cur = queue.removeFirst()

                if (cur.mask == resultMask) return cur.distance

                if (cur.energy == 0) continue

                for (i in 0 until 4) {
                    val nr = cur.r + dr[i]
                    val nc = cur.c + dc[i]

                    if (nr !in 0 until m || nc !in 0 until n) continue
                    if (classroom[nr][nc] == 'X') continue

                    var nextMask = cur.mask
                    var nextEnergy = cur.energy - 1

                    when (classroom[nr][nc]) {
                        'L' -> {
                            val index = litterIndex[nr][nc]
                            nextMask = nextMask or (1 shl index)
                        }

                        'R' -> {
                            nextEnergy = energy
                        }

                        '.',
                        'S' -> Unit
                    }

                    if (nextEnergy <= maxEnergy[nr][nc][nextMask]) continue
                    maxEnergy[nr][nc][nextMask] = nextEnergy
                    queue +=
                        Student(
                            r = nr,
                            c = nc,
                            mask = nextMask,
                            energy = nextEnergy,
                            distance = cur.distance + 1,
                        )
                }
            }
            return -1
        }
    }
}
