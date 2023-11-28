plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.pokemonapijson"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.pokemonapijson"
        minSdk = 27
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
// Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    // Conversor Gson para Retrofit
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    // Cliente HTTP OkHttp para logging en Retrofit
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}