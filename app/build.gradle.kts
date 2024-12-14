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
    namespace = "com.galaxyjoy.cpuinfo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.galaxyjoy.cpuinfo"

        minSdk = 21
        targetSdk = 34
        versionCode = 20241211
        versionName = "2024.12.11"

        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        externalNativeBuild {
            cmake {
                arguments += "-DANDROID_STL=c++_static"
            }
        }
    }

    ndkVersion = "25.1.8937393"

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
            storePassword = "27072000"
            keyAlias = "mckimquyen"
            keyPassword = "27072000"
        }
    }

    buildTypes {
        debug {
            signingConfig = signingConfigs.getByName("debug")
            isMinifyEnabled = false
            enableUnitTestCoverage = true
//            applicationIdSuffix = ".debug"
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

    kotlinOptions {
        jvmTarget = "11"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.AndroidX.Compose.compilerVersion
    }

    flavorDimensions.add("type")
    productFlavors {
        create("dev") {
            dimension = "type"
            resValue("string", "app_name", "Device Info & System CPU DEV")
            resValue(
                "string",
                "SDK_KEY",
                "e75FnQfS9XTTqM1Kne69U7PW_MBgAnGQTFvtwVVui6kRPKs5L7ws9twr5IQWwVfzPKZ5pF2IfDa7lguMgGlCyt"
            )
            resValue("string", "BANNER", "xxx")
            resValue("string", "INTER", "xxx")

            resValue("string", "EnableAdInter", "true")
            resValue("string", "EnableAdBanner", "true")
        }
        create("production") {
            dimension = "type"
            resValue("string", "app_name", "Device Info & System CPU")
            resValue(
                "string",
                "SDK_KEY",
                "e75FnQfS9XTTqM1Kne69U7PW_MBgAnGQTFvtwVVui6kRPKs5L7ws9twr5IQWwVfzPKZ5pF2IfDa7lguMgGlCyt"
            )
            resValue("string", "BANNER", "xxx")
            resValue("string", "INTER", "xxx")

            resValue("string", "EnableAdInter", "true")
            resValue("string", "EnableAdBanner", "true")
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.22")
    implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.fragment:fragment-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.preference:preference:1.2.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("androidx.viewpager2:viewpager2:1.0.0")
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.6.1")
    implementation(platform(Libs.AndroidX.Compose.bom))
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.animation:animation")
    implementation("androidx.compose.ui:ui-tooling-preview")
//    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.navigation:navigation-fragment-ktx:2.6.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.6.0")
    implementation("com.google.android.material:material:1.9.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("io.reactivex.rxjava3:rxjava:3.1.6")
    implementation("io.reactivex.rxjava3:rxandroid:3.0.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.2")
    implementation("com.google.dagger:hilt-android:2.47")
    kapt("com.google.dagger:hilt-android-compiler:2.47")
    implementation("com.github.bumptech.glide:glide:4.15.1")
    kapt("com.github.bumptech.glide:compiler:4.15.1")
    implementation("com.airbnb.android:epoxy:5.1.3")
    implementation("com.airbnb.android:epoxy-databinding:5.1.3")
    kapt("com.airbnb.android:epoxy-processor:5.1.3")
    implementation("org.greenrobot:eventbus:3.3.1")
    implementation("com.jakewharton.timber:timber:5.0.1")
    implementation("com.getkeepsafe.relinker:relinker:1.4.5")
    implementation("io.coil-kt:coil-compose:2.4.0")
    implementation("com.applovin:applovin-sdk:13.0.1")
    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.14")

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
    implementation("com.google.android.play:review:2.0.2")
    implementation("com.google.android.play:review-ktx:2.0.2")
}
