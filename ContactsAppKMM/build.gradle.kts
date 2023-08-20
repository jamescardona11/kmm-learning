buildscript {
	dependencies {
		classpath("app.cash.sqldelight:gradle-plugin:2.0.0")
	}
}

plugins {
	//trick: for the same plugin versions in all sub-modules
	id("com.android.application").version("8.1.0").apply(false)
	id("com.android.library").version("8.1.0").apply(false)
	kotlin("android").version("1.8.21").apply(false)
	kotlin("multiplatform").version("1.8.21").apply(false)
	id("org.jetbrains.compose").version("1.4.3").apply(false)

}

tasks.register("clean", Delete::class) {
	delete(rootProject.buildDir)
}
