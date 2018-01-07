lazy val changelog = "changelog.txt"

lazy val root = (project in file("."))
  .settings(
    name := "sandbox-rpm",
    version := "0.0.1",
    maintainer in Linux := "Kason Chan <kasonl.chan@gmail.com>",
    packageSummary in Linux := "Sandbox Akka HTTP RPM",
    packageDescription in Rpm := "Sandbox Akka HTTP RPM",
    rpmBrpJavaRepackJars := true,
    rpmRelease := "1",
    rpmVendor := "kasonchan",
    rpmGroup := Some("sandbox-rpm"),
    rpmUrl := Some("https://github.com/kasonchan/sandbox-rpm"),
    rpmLicense := Some("Apache v2"),
    rpmChangelogFile := Some(changelog),
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % "10.0.10",
      "com.typesafe.akka" %% "akka-http-testkit" % "10.0.10" % Test,
      "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.10"
    ))
  .enablePlugins(JavaServerAppPackaging, SystemdPlugin, RpmPlugin)
