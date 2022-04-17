import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val jaxwsToolsVersion = "2.3.1"

plugins {
    id("java")
    id("org.springframework.boot") version "2.6.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.10"
    id("org.jetbrains.kotlin.plugin.noarg") version "1.6.10"
    id("com.yupzip.wsdl2java") version "2.0"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
}

group = "org.bajiepka"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

buildscript {
    dependencies {
        classpath("javax.xml.bind:jaxb-api:2.4.0-b180830.0359")
        classpath("org.glassfish.jaxb:jaxb-runtime:2.4.0-b180830.0438")
        classpath("com.sun.xml.ws:jaxws-tools:2.3.1") {
            exclude(group = "com.sun.xml.ws", module = "policy")
        }
    }
}

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-web-services")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.liquibase:liquibase-core")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.webjars:webjars-locator:0.45")
    implementation("org.webjars:bootstrap:5.1.3")
    implementation("org.jsoup:jsoup:1.14.3")
    implementation("io.github.microutils:kotlin-logging:2.1.21")
    implementation("com.sun.xml.ws:jaxws-tools:$jaxwsToolsVersion")

    runtimeOnly("org.postgresql:postgresql")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

allOpen {
    annotation("javax.persistence.Entity")
}

noArg {
    annotation("javax.persistence.Entity")
}

wsdl2java {
    wsdlDir = file("${projectDir}/src/main/resources/wsdl")
    wsdlsToGenerate = listOf(
        listOf("$wsdlDir/cbr_daily_info.wsdl")
    )
    encoding = Charsets.UTF_8.name()
}

task("copyWsdl") {
    copy {
        from("src/main/resources/wsdl")
        into("build/src/main/resources/wsdl")
    }
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
        dependsOn("copyWsdl", "wsdl2java")
    }

    withType<Test> {
        useJUnitPlatform()
    }
}
