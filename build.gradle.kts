plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.junit:junit-bom:5.14.3"))
    implementation("org.junit.jupiter:junit-jupiter")
    implementation("org.junit.platform:junit-platform-launcher")
    implementation("org.junit.platform:junit-platform-suite")

    implementation("io.rest-assured:rest-assured:5.5.0")
    implementation("io.rest-assured:json-schema-validator:5.5.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")
}

tasks.test {
    useJUnitPlatform()
}