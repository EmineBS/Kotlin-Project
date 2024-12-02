buildscript {
    val agp_version by extra("8.1.2")
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "2.0.20" apply false
    id("com.google.dagger.hilt.android") version "2.51" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.20" apply false
}
val compileSdkVersion by extra(34)
