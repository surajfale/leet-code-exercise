lazy val root = (project in file("."))
    .settings(
        name := "leetcode",
        organization := "com.suraj.leetcode",
        homepage := Some(new URL("https://github.com/surajfale/leet-code-exercise")),
        scalaVersion := "2.13.6",
        semanticdbEnabled := true,
        scalacOptions ++= Seq("-Xlint", "-Yrangepos", "-Wunused:imports", "-Xfatal-warnings"),
        Test / parallelExecution := false,
        libraryDependencies ++= Seq(
            "org.scalatest" %% "scalatest" % "3.2.9" % "test"
        )
    )