plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version Deps.kotlinVersion
}

android {
    namespace = "com.darrenthiores.betrbeta"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.darrenthiores.betrbeta"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "BASE_URL", "\"dev-pu-web.betrbeta.com\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Deps.composeUi)
    implementation(Deps.composeUiTooling)
    implementation(Deps.composeUiToolingPreview)
    implementation(Deps.composeFoundation)
    implementation(Deps.composeMaterial)
    implementation(Deps.activityCompose)
    implementation(Deps.composeIconsExtended)
    implementation(Deps.composeNavigation)
    implementation(Deps.coilCompose)

    implementation(Deps.viewModel)
    implementation(Deps.viewModelCompose)
    implementation(Deps.hiltViewModel)

    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltAndroidCompiler)
    kapt(Deps.hiltCompiler)

    implementation(Deps.ktorAndroid)
    implementation(Deps.ktorCore)
    implementation(Deps.ktorSerialization)
    implementation(Deps.ktorSerializationJson)
    implementation(Deps.ktorAuth)
    implementation(Deps.ktorClientLogging)
    implementation(Deps.logBackClassic)

    implementation(Deps.kotlinDateTime)

    implementation(Deps.encPreferences)

    implementation(Deps.timber)

    testImplementation(Deps.junit4)
    testImplementation(Deps.junitAndroidExt)
    testImplementation(Deps.truth)
    testImplementation(Deps.coroutines)
    testImplementation(Deps.turbine)
    testImplementation(Deps.composeUiTest)
    testImplementation(Deps.mockk)
    testImplementation(Deps.dexMaker)
    testImplementation(Deps.mockWebServer)

    androidTestImplementation(Deps.junit4)
    androidTestImplementation(Deps.junitAndroidExt)
    androidTestImplementation(Deps.truth)
    androidTestImplementation(Deps.coroutines)
    androidTestImplementation(Deps.turbine)
    androidTestImplementation(Deps.composeUiTest)
    androidTestImplementation(Deps.mockkAndroid)
    androidTestImplementation(Deps.mockWebServer)
    androidTestImplementation(Deps.hiltTesting)
    kaptAndroidTest(Deps.hiltCompiler)
    androidTestImplementation(Deps.testRunner)
}