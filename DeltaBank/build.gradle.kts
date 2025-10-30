plugins {
    id("java")

}

group = "org.mathiasus"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"));
    testImplementation("org.junit.jupiter:junit-jupiter");
    testRuntimeOnly("org.junit.platform:junit-platform-launcher");
    // https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation("com.google.code.gson:gson:2.13.2");
    // https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api
    implementation("javax.xml.bind:jaxb-api:2.3.1");

    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.17.0");

    // https://mvnrepository.com/artifact/com.google.inject/guice
    implementation("com.google.inject:guice:7.0.0");

    // https://mvnrepository.com/artifact/org.javatuples/javatuples
    implementation("org.javatuples:javatuples:1.2");

    // https://mvnrepository.com/artifact/net.dongliu/gson-java8-datatype
//    implementation(group = "com.google.code.gson", name = "gson-extras", version = "2.13.2-rc1")
}

tasks.test {
    useJUnitPlatform()
}