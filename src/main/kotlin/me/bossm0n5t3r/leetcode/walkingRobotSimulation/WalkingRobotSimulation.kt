package me.bossm0n5t3r.leetcode.walkingRobotSimulation

class WalkingRobotSimulation {
    class Solution {
        fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
            val robot = Robot(obstacles)
            for (command in commands) {
                robot.move(command)
            }
            return robot.furthestDistance
        }

        class Robot(obstacles: Array<IntArray>) {
            private var x: Int = 0
            private var y: Int = 0
            private var curDirection: Direction = Direction.NORTH
            private val obstaclesSet = obstacles.map { it[0] to it[1] }.toSet()
            var furthestDistance = 0

            enum class Direction {
                NORTH,
                EAST,
                SOUTH,
                WEST;

                fun turnRight(): Direction {
                    val totalSize = Direction.entries.size
                    return Direction.entries[(ordinal + 1) % totalSize]
                }

                fun turnLeft(): Direction {
                    val totalSize = Direction.entries.size
                    return Direction.entries[(ordinal - 1 + totalSize) % totalSize]
                }
            }

            fun move(command: Int) {
                when (command) {
                    -2 -> {
                        curDirection = this.curDirection.turnLeft()
                    }

                    -1 -> {
                        curDirection = this.curDirection.turnRight()
                    }

                    else -> {
                        var count = command
                        when (curDirection) {
                            Direction.NORTH ->
                                while (
                                    count > 0 && obstaclesSet.contains(this.x to (this.y + 1)).not()
                                ) {
                                    y++
                                    count--
                                }

                            Direction.EAST ->
                                while (
                                    count > 0 && obstaclesSet.contains((this.x + 1) to this.y).not()
                                ) {
                                    x++
                                    count--
                                }

                            Direction.SOUTH ->
                                while (
                                    count > 0 && obstaclesSet.contains(this.x to (this.y - 1)).not()
                                ) {
                                    y--
                                    count--
                                }

                            Direction.WEST ->
                                while (
                                    count > 0 && obstaclesSet.contains((this.x - 1) to this.y).not()
                                ) {
                                    x--
                                    count--
                                }
                        }
                        furthestDistance =
                            maxOf(furthestDistance, this.x * this.x + this.y * this.y)
                    }
                }
            }
        }
    }
}
