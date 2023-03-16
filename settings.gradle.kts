pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0"
}

rootProject.name = "warpdrive-parent"
include(
        "api",
        "proxy",
        "native"
)
findProject(":api")?.name = "warpdrive-api"
findProject(":proxy")?.name = "warpdrive-proxy"
findProject(":native")?.name = "warpdrive-native"
