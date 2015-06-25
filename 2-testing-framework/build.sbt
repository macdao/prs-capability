lazy val root = (project in file(".")).
  settings(
    name := "2-testing-framework",
    version := "1.0",
    scalaVersion := "2.11.4",
    libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test",
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test",
    libraryDependencies += "com.github.stefanbirkner" % "system-rules" % "1.11.0" % "test",
    libraryDependencies += "commons-io" % "commons-io" % "2.0" % "test" force(),
    crossPaths := false
  )