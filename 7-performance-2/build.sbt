lazy val root = (project in file(".")).
  settings(
    name := "7-performance-2",
    version := "1.0",
    scalaVersion := "2.11.4",
    libraryDependencies += "com.google.guava" % "guava" % "18.0",
    libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test",
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test",
    libraryDependencies += "com.github.stefanbirkner" % "system-rules" % "1.12.1" % "test",
    libraryDependencies += "org.mockito" % "mockito-core" % "1.10.19" % "test",
    crossPaths := false
  )
