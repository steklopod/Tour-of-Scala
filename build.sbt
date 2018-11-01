name := "Tour-of-Scala"
version := "0.7"

scalaVersion := "2.12.6"

val slf4j = "1.8.0-beta2"

libraryDependencies ++= Seq(
  "org.slf4j"          % "slf4j-api"               % slf4j,
  "org.slf4j"          % "slf4j-simple"            % slf4j,
  "org.scalatest"      %% "scalatest"              % "3.2.0-SNAP10" % Test,
  "org.scalacheck"     %% "scalacheck"             % "1.13.5" % "test",
  "junit"              % "junit"                   % "4.12" % Test,
  "org.junit.jupiter"  % "junit-jupiter-api"       % "5.2.0" % Test,
  "org.junit.jupiter"  % "junit-jupiter-engine"    % "5.2.0" % Test,
  "org.junit.jupiter"  % "junit-jupiter-params"    % "5.2.0" % Test,
  "org.junit.platform" % "junit-platform-launcher" % "1.2.0" % Test,
  "org.junit.platform" % "junit-platform-engine"   % "1.2.0" % Test,
  "org.junit.platform" % "junit-platform-runner"   % "1.2.0" % Test,
  "com.geirsson"       %% "scalafmt-core"          % "1.5.1",
)

resolvers ++= Seq(
  DefaultMavenRepository,
  Resolver.mavenLocal,
  Resolver.sonatypeRepo("snapshots"),
  Classpaths.typesafeReleases
)
