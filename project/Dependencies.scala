import sbt.{Def, _}
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._

object Dependencies {

  object V {

    val refined       = "0.9.29"

    val tyrian      = "0.3.2"

    val scalacheck = "1.16.0"
    val weaver     = "0.7.12"

    val organizeImports = "0.6.0"

    val ip4s       = "3.1.3"
  }

  object Libraries {


    val logBack = "ch.qos.logback" % "logback-classic" % "1.2.11"

    val refinedCore = Def.setting("eu.timepit" %%% "refined" % V.refined)
    val refinedCats = Def.setting("eu.timepit" %%% "refined-cats" % V.refined)

    val scalacheck       = "org.scalacheck"      %% "scalacheck"        % V.scalacheck
    val weaverCats       = "com.disneystreaming" %% "weaver-cats"       % V.weaver
    val weaverDiscipline = "com.disneystreaming" %% "weaver-discipline" % V.weaver
    val weaverScalaCheck = "com.disneystreaming" %% "weaver-scalacheck" % V.weaver

    // scalafix rules
    val organizeImports = "com.github.liancheng" %% "organize-imports" % V.organizeImports

    val ip4s = "com.comcast" %% "ip4s-core" % V.ip4s

  }

}
