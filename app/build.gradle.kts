plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

kapt {
    correctErrorTypes = true
    useBuildCache = true
}

android {
    namespace = "com.roy93group.cpuinfo"
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        applicationId = "com.roy93group.cpuinfo"

        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
        versionCode = 20230728
        versionName = "2023.07.28"

        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        externalNativeBuild {
            cmake {
                arguments += "-DANDROID_STL=c++_static"
            }
        }
    }

    ndkVersion = Versions.NDK_VERSION

    signingConfigs {
        getByName("debug") {
//            val debugSigningConfig = SigningConfig.getDebugProperties(rootProject.rootDir)
//            storeFile = file(debugSigningConfig.getProperty(SigningConfig.KEY_PATH))
//            keyAlias = debugSigningConfig.getProperty(SigningConfig.KEY_ALIAS)
//            keyPassword = debugSigningConfig.getProperty(SigningConfig.KEY_PASS)
//            storePassword = debugSigningConfig.getProperty(SigningConfig.KEY_PASS)
        }
        create("release") {
//            val releaseSigningConfig = SigningConfig.getReleaseProperties(rootProject.rootDir)
//            storeFile = file(releaseSigningConfig.getProperty(SigningConfig.KEY_PATH))
//            keyAlias = releaseSigningConfig.getProperty(SigningConfig.KEY_ALIAS)
//            keyPassword = releaseSigningConfig.getProperty(SigningConfig.KEY_PASS)
//            storePassword = releaseSigningConfig.getProperty(SigningConfig.KEY_PASS)

            storeFile = file("keystore.jks")
            storePassword = "04021993"
            keyAlias = "loi"
            keyPassword = "04021993"
        }
    }

    buildTypes {
        debug {
            signingConfig = signingConfigs.getByName("debug")
            isMinifyEnabled = false
            enableUnitTestCoverage = true
            applicationIdSuffix = ".debug"
        }
        release {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    externalNativeBuild {
        cmake {
            path("src/main/cpp/CMakeLists.txt")
        }
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
        compose = true
        aidl = true
        buildConfig = true
    }

    testOptions {
        unitTests {
            isReturnDefaultValues = true
            isIncludeAndroidResources = true
        }
        animationsDisabled = true
        execution = "ANDROIDX_TEST_ORCHESTRATOR"
    }

    lint {
        abortOnError = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.AndroidX.Compose.compilerVersion
    }

    flavorDimensions.add("type")

    productFlavors {
        create("dev") {
            setDimension("type")
//            buildConfigField("String", "FLAVOR_buildEnv", "dev")

            resValue ("string", "app_name", "CPU Info DEV")

            //TODO correct key
            resValue("string", "SDK_KEY", "e75FnQfS9XTTqM1Kne69U7PW_MBgAnGQTFvtwVVui6kRPKs5L7ws9twr5IQWwVfzPKZ5pF2IfDa7lguMgGlCyt")
            resValue("string", "BANNER", "xxx")
            resValue("string", "INTER", "xxx")

            resValue("string", "EnableAdInter", "true")
            resValue("string", "EnableAdBanner", "true")
        }
        create("production") {
            setDimension("type")
//            buildConfigField("String", "FLAVOR_buildEnv", "prod")

            resValue ("string", "app_name", "CPU Info")

            //TODO correct key
            resValue("string", "SDK_KEY", "e75FnQfS9XTTqM1Kne69U7PW_MBgAnGQTFvtwVVui6kRPKs5L7ws9twr5IQWwVfzPKZ5pF2IfDa7lguMgGlCyt")
            resValue("string", "BANNER", "xxx")
            resValue("string", "INTER", "xxx")

            resValue("string", "EnableAdInter", "true")
            resValue("string", "EnableAdBanner", "true")
        }
    }
}

dependencies {
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Kotlin.immutable)
    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.activityKtx)
    implementation(Libs.AndroidX.fragmentKtx)
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.preference)
    implementation(Libs.AndroidX.swipeRefreshLayout)
    implementation(Libs.AndroidX.constraintLayout)
    implementation(Libs.AndroidX.multiDex)
    implementation(Libs.AndroidX.viewPager2)
    implementation(Libs.AndroidX.datastorePreferences)
    implementation(Libs.AndroidX.Lifecycle.viewModelKtx)
    implementation(Libs.AndroidX.Lifecycle.runtimeCompose)
    implementation(Libs.AndroidX.Lifecycle.liveDataKtx)
    implementation(Libs.AndroidX.Lifecycle.common)
    implementation(platform(Libs.AndroidX.Compose.bom))
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.material3)
    implementation(Libs.AndroidX.Compose.animations)
    implementation(Libs.AndroidX.Compose.uiToolingPreview)
    debugImplementation(Libs.AndroidX.Compose.uiTooling)
    implementation(Libs.AndroidX.Navigation.fragment)
    implementation(Libs.AndroidX.Navigation.ui)
    implementation(Libs.Google.material)
    implementation(Libs.Google.gson)
    implementation(Libs.Rx.rxJava)
    implementation(Libs.Rx.rxAndroid)
    implementation(Libs.Coroutines.core)
    implementation(Libs.Coroutines.android)
    implementation(Libs.Hilt.android)
    kapt(Libs.Hilt.androidCompiler)
    implementation(Libs.Glide.glide)
    kapt(Libs.Glide.compiler)
    implementation(Libs.Airbnb.epoxy)
    implementation(Libs.Airbnb.dataBinding)
    kapt(Libs.Airbnb.processor)
    implementation(Libs.bus)
    implementation(Libs.timber)
    implementation(Libs.relinker)
    implementation(Libs.coil)
    implementation ("com.applovin:applovin-sdk:11.11.1")
    debugImplementation ("com.squareup.leakcanary:leakcanary-android:2.12")

//    testImplementation(Libs.junit)
//    testImplementation(Libs.AndroidX.Test.core)
//    testImplementation(Libs.AndroidX.Test.archCoreTesting)
//    testImplementation(Libs.Mockito.core)
//    testImplementation(Libs.Mockito.kotlin)
//    testImplementation(Libs.Hilt.androidTesting)
//    testImplementation(kotlin("test"))
//    kaptTest(Libs.Hilt.androidCompiler)
//    androidTestImplementation(Libs.AndroidX.Test.runner)
//    androidTestImplementation(Libs.AndroidX.Test.rules)
//    androidTestImplementation(Libs.AndroidX.Test.jUnitExt)
//    androidTestImplementation(Libs.AndroidX.Test.Espresso.core)
//    androidTestImplementation(Libs.AndroidX.Test.Espresso.contrib)
//    androidTestImplementation(Libs.Hilt.androidTesting)
//    kaptAndroidTest(Libs.Hilt.androidCompiler)
//    androidTestUtil(Libs.AndroidX.Test.orchestrator)
}
