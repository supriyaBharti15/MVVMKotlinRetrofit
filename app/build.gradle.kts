plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("org.jetbrains.kotlin.kapt")
}

android {
    dataBinding {
        enable = true
    }
    namespace = "com.example.mvvmtest3"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mvvmtest3"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.fragment.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    
//navigation fragment
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    //coroutines
    implementation(libs.androidx.coroutines.core.ktx)
    implementation(libs.androidx.coroutines.ktx)

// Retrofit
    implementation(libs.androidx.retrofit2.converter.gson)
    implementation(libs.androidx.retrofit2)
    implementation(libs.androidx.okhttp3.logging.interceptor)

//view model
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
//New Material Design
    implementation(libs.androidx.android.material.ktx)
    implementation(libs.androidx.arch.lifecycle.viewmodel)
    // ViewModel and LiveData
    implementation(libs.androidx.lifecycle)
    //image  loader
    implementation(libs.androidx.glide.bumptech)

}