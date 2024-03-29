plugins {
	kotlin("multiplatform")
	id("com.android.library")
	id("org.jetbrains.compose")
	id("app.cash.sqldelight")

}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
	targetHierarchy.default()

	android {
		compilations.all {
			kotlinOptions {
				jvmTarget = "17"
			}
		}
	}

	targets.withType(org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget::class.java).all {
		binaries.withType(org.jetbrains.kotlin.gradle.plugin.mpp.Framework::class.java).all {
			export("dev.icerock.moko:mvvm-core:0.16.1")
		}
	}

	listOf(
		iosX64(),
		iosArm64(),
		iosSimulatorArm64()
	).forEach {
		it.binaries.framework {
			baseName = "shared"
			isStatic = true
		}
	}

	val sqlLightVersion = "2.0.0"
	sourceSets {
		val commonMain by getting {
			dependencies {
				implementation(compose.runtime)
				implementation(compose.foundation)
				implementation(compose.material3)
				implementation(compose.materialIconsExtended)
				@OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
				implementation(compose.components.resources)

				implementation("app.cash.sqldelight:runtime:$sqlLightVersion")
				implementation("app.cash.sqldelight:coroutines-extensions:$sqlLightVersion")
				implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
				implementation("dev.icerock.moko:mvvm-core:0.16.1")
				implementation("dev.icerock.moko:mvvm-compose:0.16.1")
				implementation("dev.icerock.moko:mvvm-flow:0.16.1")
				implementation("dev.icerock.moko:mvvm-flow-compose:0.16.1")


			}
		}
		val commonTest by getting {
			dependencies {
				implementation(kotlin("test"))
			}
		}
		val androidMain by getting {
			dependencies {
				implementation("app.cash.sqldelight:android-driver:$sqlLightVersion")
				implementation("androidx.appcompat:appcompat:1.6.1")
				implementation("androidx.activity:activity-compose:1.7.2")
			}
		}
		val androidUnitTest by getting
		val iosX64Main by getting
		val iosArm64Main by getting
		val iosSimulatorArm64Main by getting
		val iosMain by getting {
			dependencies {
				implementation("app.cash.sqldelight:native-driver:$sqlLightVersion")
			}
			dependsOn(commonMain)
			iosX64Main.dependsOn(this)
			iosArm64Main.dependsOn(this)
			iosSimulatorArm64Main.dependsOn(this)
		}
		val iosX64Test by getting
		val iosArm64Test by getting
		val iosSimulatorArm64Test by getting
		val iosTest by getting {
			dependsOn(commonTest)
			iosX64Test.dependsOn(this)
			iosArm64Test.dependsOn(this)
			iosSimulatorArm64Test.dependsOn(this)
		}


	}

}

android {
	namespace = "com.tkmonkey.contactsappkmm"
	compileSdk = 33
	defaultConfig {
		minSdk = 24
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}
}


sqldelight {
	databases {
		create("ContactDatabase") {
			packageName.set("database")
//			generateAsync.set(true)
		}
	}
}


dependencies {
	implementation("androidx.core:core:1.10.1")
	commonMainApi("dev.icerock.moko:mvvm-core:0.16.1")
	commonMainApi("dev.icerock.moko:mvvm-compose:0.16.1")
	commonMainApi("dev.icerock.moko:mvvm-flow:0.16.1")
	commonMainApi("dev.icerock.moko:mvvm-flow-compose:0.16.1")
}