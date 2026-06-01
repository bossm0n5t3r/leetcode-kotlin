package me.bossm0n5t3r.leetcode.compareVersionNumbers

class CompareVersionNumbers {
    class Solution {
        data class VersionManager(private val versions: List<Int>) : Comparable<VersionManager> {
            constructor(versionString: String) : this(versionString.split(".").map { it.toInt() })

            override fun compareTo(other: VersionManager): Int {
                val maxLength = maxOf(this.versions.size, other.versions.size)
                for (i in 0 until maxLength) {
                    val thisVersion = this.versions.getOrElse(i) { 0 }
                    val otherVersion = other.versions.getOrElse(i) { 0 }
                    if (thisVersion != otherVersion) {
                        return thisVersion.compareTo(otherVersion)
                    }
                }
                return 0
            }
        }

        fun compareVersion(version1: String, version2: String): Int =
            VersionManager(version1).compareTo(VersionManager(version2))
    }
}
