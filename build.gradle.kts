buildscript {
    val agp_version by extra("8.3.2")
}
plugins {
    id("com.android.application") version "8.3.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.23" apply false
    id("com.android.library") version "8.3.2" apply false
}