plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "ReativeFeed"
include("src:main:controller")
findProject(":src:main:controller")?.name = "controller"
include("src:controller:application")
findProject(":src:controller:application")?.name = "application"
include("src:main:testeee")
findProject(":src:main:testeee")?.name = "testeee"
