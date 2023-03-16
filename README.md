# Warpdrive

[![Build Status](https://img.shields.io/github/actions/workflow/status/astei/warprive/gradle.yml)](https://papermc.io/downloads#Velocity)
[![Join our Discord](https://img.shields.io/discord/598283901802381323.svg?logo=discord&label=)](https://discord.gg/bXh6FaTY)

Experimental hard fork of Velocity, from the original author.

## Building

Warpdrive is built with [Gradle](https://gradle.org). We recommend using the
wrapper script (`./gradlew`) as our CI builds using it.

It is sufficient to run `./gradlew build` to run the full build cycle.

## Running

Once you've built Warpdrive, you can copy and run the `-all` JAR from
`proxy/build/libs`. Warpdrive will generate a default configuration file
and you can configure it from there.
