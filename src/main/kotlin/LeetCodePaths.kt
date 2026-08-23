import java.nio.file.Path
import java.nio.file.Paths

private val projectPath: Path = Paths.get("").toAbsolutePath().normalize()

internal val problemPath: Path = projectPath.resolve("src/main/kotlin/me/bossm0n5t3r/leetcode")

internal val testPath: Path = projectPath.resolve("src/test/kotlin/me/bossm0n5t3r/leetcode")
