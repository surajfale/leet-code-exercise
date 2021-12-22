lazy val root = (project in file("."))
    .settings(
        name := "leetcode",
        organization := "com.suraj.leetcode",
        homepage := Some(new URL("https://github.com/surajfale/leet-code-exercise")),
        scalaVersion := "3.1.0",
        semanticdbEnabled := true,
        scalacOptions ++= Seq(
            "-deprecation",
            "-explain",
            "-explain-types",
            "-new-syntax",
            "-unchecked",
            "-Xfatal-warnings",
            "-Xmigration",
            "-Ykind-projector",
            "-print-lines"
        ),
        Test / parallelExecution := false,
        libraryDependencies ++= Seq(
            "org.scalatest" %% "scalatest" % "3.2.9" % "test"
        )
    )