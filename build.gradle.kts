import dev.s7a.gradle.minecraft.server.tasks.LaunchMinecraftServerTask

plugins {
	id ("idea")
    id("org.jetbrains.kotlin.jvm") version "1.8.10"
    id ("com.github.johnrengelman.shadow") version "7.1.2"
    id ("dev.s7a.gradle.minecraft.server") version "2.1.0"
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")
    compileOnly("io.papermc.paper:paper-api:1.18.1-R0.1-SNAPSHOT")
}

task<LaunchMinecraftServerTask>("testPlugin") {
    dependsOn("shadowJar")

    doFirst {
        copy {
            from(buildDir.resolve("libs/${project.name}-all.jar"))
            into(buildDir.resolve("MinecraftServer/plugins"))
        }
    }

    jarUrl.set(LaunchMinecraftServerTask.JarUrl.Paper("1.18.2"))
    agreeEula.set(true)
}
