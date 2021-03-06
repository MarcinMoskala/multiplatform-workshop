buildscript {
    val kotlin_version = "1.3.61"
    val sqldelight_version = "1.2.2"
    val xcodesync_version = "0.1.5"

    repositories {
        google()
        maven ("https://plugins.gradle.org/m2/")
        maven ("https://dl.bintray.com/kotlin/kotlin-eap" )
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.5.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlin_version")
        classpath("gradle.plugin.com.wiredforcode:gradle-spawn-plugin:0.8.2")
        classpath("com.squareup.sqldelight:gradle-plugin:$sqldelight_version")
        classpath("co.touchlab:kotlinxcodesync:$xcodesync_version")
    }
}

plugins {
    id("com.github.ben-manes.versions") version "0.27.0"
}

allprojects {
    repositories {
        maven ( "https://dl.bintray.com/kotlin/kotlinx" )
        maven ( "https://dl.bintray.com/kotlin/ktor" )
        maven ( "https://dl.bintray.com/soywiz/soywiz" )
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}