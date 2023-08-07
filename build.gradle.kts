import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    val kotlinVersion = "1.9.0"
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.7.0")
        classpath("io.spring.gradle:dependency-management-plugin:1.0.11.RELEASE")
        classpath("org.jetbrains.kotlin:kotlin-noarg:$kotlinVersion")
    }
}

plugins {
    val kotlinVersion = "1.9.0"
    val springBootVersion = "2.7.0"

    id("org.springframework.boot") version springBootVersion
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    id("io.gitlab.arturbosch.detekt") version "1.23.1"

    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
//  kotlin("plugin.jpa") version kotlinVersion
    kotlin("plugin.noarg") version kotlinVersion
    kotlin("kapt") version kotlinVersion
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}

dependencyManagement {
    imports {
        mavenBom("io.awspring.cloud:spring-cloud-aws-dependencies:2.3.3")
    }
}

apply {
    plugin("io.spring.dependency-management")
    plugin("org.springframework.boot")
    plugin("org.jetbrains.kotlin.plugin.spring")

    plugin("kotlin")
    plugin("kotlin-spring")
    plugin("kotlin-jpa")
    plugin("kotlin-kapt")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.21")
    implementation("org.springframework.boot:spring-boot-starter-web")
//  implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("io.springfox:springfox-boot-starter:3.0.0")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    kapt("org.springframework.boot:spring-boot-configuration-processor")
    implementation("com.google.code.gson:gson:2.10.1")

    implementation("io.awspring.cloud:spring-cloud-starter-aws-parameter-store-config")

    runtimeOnly("mysql:mysql-connector-java")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
        freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

detekt {
    toolVersion = "1.23.1"
    config = files("detekt-config.yaml")
    buildUponDefaultConfig = true
}
