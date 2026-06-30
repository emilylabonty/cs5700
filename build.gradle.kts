plugins {
    kotlin("jvm") version "2.0.21"
}

group = "shapes"
version = "1.0.0"

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.3")
}

tasks.test {
    useJUnitPlatform()
}