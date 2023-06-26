buildscript {
    dependencies {
        classpath("net.pwall.json:json-kotlin-gradle:0.90")
    }
}

plugins {
    id("com.projectronin.interop.gradle.version")
    id("com.projectronin.interop.gradle.publish")
    id("com.projectronin.interop.gradle.junit")
    id("com.projectronin.event.contract")
}

dependencies {
    implementation(libs.guava)
}

apply<net.pwall.json.kotlin.codegen.gradle.JSONSchemaCodegenPlugin>()

sourceSets.main {
    java.srcDirs("build/generated-sources/kotlin")
}

configure<net.pwall.json.kotlin.codegen.gradle.JSONSchemaCodegen> {
    packageName.set("com.projectronin.event.interop.internal")
    inputs {
        inputFile {
            file.set(file("v1"))
            subPackage.set("v1")
        }
    }
}
