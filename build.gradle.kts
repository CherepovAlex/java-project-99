plugins {
	java
	application
	checkstyle
	jacoco
	id("io.freefair.lombok") version "8.6"
	id("org.sonarqube") version "6.2.0.5505"
	id("org.springframework.boot") version "3.5.4"
	id("io.spring.dependency-management") version "1.1.7"
	id("com.github.ben-manes.versions") version "0.50.0"
	id("io.sentry.jvm.gradle") version "5.3.0"
}

application {
	mainClass = "hexlet.code.AppApplication"
}

group = "hexlet.code"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
//	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//	implementation("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
