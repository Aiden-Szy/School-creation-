plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android) // 确保这里只包含 Kotlin Android 插件
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.example.myapp" // 确保这个包名与你的应用匹配
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    // 如果确实需要夜间模式资源文件夹，则保持；否则移除
    // sourceSets.getByName("main").res.srcDirs += "src/main/res-night"
}

dependencies {
    // Local JAR files
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // AndroidX Libraries
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.fragment)
    implementation(libs.material)

    // Testing libraries
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Networking and JSON parsing
    implementation(libs.okhttp)
    implementation(libs.gson)

    // UI components
    implementation(libs.flyco.tablayout.lib) // 不再需要 '.aar'
    implementation(libs.recyclerview)
    implementation(libs.picasso)
    implementation(libs.smart.refresh.layout)

    // Multimedia player (仅包含必要的模块)
    implementation(libs.dkplayer.java)
    implementation(libs.dkplayer.ui)

    // View binding (Butter Knife 已被弃用，建议使用 Android 的内置视图绑定或 Data Binding)
    implementation(libs.butterknife)

    // Skin support
    implementation(libs.skin.support)
    implementation(libs.skin.support.appcompat)
    implementation(libs.flycotablayout)
    //noinspection GradleDependency
    implementation("androidx.appcompat:appcompat:1.7.0")


    //Android智能下拉刷新框架-SmartRefreshLayout
    implementation("androidx.appcompat:appcompat:1.0.0")                 //必须 1.0.0 以上
    implementation("io.github.scwang90:refresh-layout-kernel:3.0.0-alpha")      //核心必须依赖
    implementation("io.github.scwang90:refresh-header-classics:3.0.0-alpha")    //经典刷新头
    implementation("io.github.scwang90:refresh-header-radar:3.0.0-alpha")       //雷达刷新头
    implementation("io.github.scwang90:refresh-header-falsify:3.0.0-alpha")     //虚拟刷新头
    implementation("io.github.scwang90:refresh-header-material:3.0.0-alpha")    //谷歌刷新头
    implementation("io.github.scwang90:refresh-header-two-level:3.0.0-alpha")   //二级刷新头
    implementation("io.github.scwang90:refresh-footer-ball:3.0.0-alpha")        //球脉冲加载
    implementation("io.github.scwang90:refresh-footer-classics:3.0.0-alpha")    //经典加载


    // DKPlayer的核心Java实现，提供基础的视频播放功能。
    implementation("xyz.doikki.android.dkplayer:dkplayer-java:3.3.6")
    // DKPlayer的UI组件库，包含了一系列预定义的UI控件和布局，用于快速搭建视频播放界面。
    implementation("xyz.doikki.android.dkplayer:dkplayer-ui:3.3.6")
    // 基于ExoPlayer的播放器实现，利用Google的ExoPlayer作为底层播放引擎。
    implementation("xyz.doikki.android.dkplayer:player-exo:3.3.6")
    // 基于IjkPlayer的播放器实现，使用Bilibili开源的IjkPlayer作为底层播放引擎。
    implementation("xyz.doikki.android.dkplayer:player-ijk:3.3.6")
    // 视频缓存库，支持边下边播，适用于网络视频流的本地缓存加速。
    implementation("xyz.doikki.android.dkplayer:videocache:3.3.6")


    //提供换肤功能的依赖项
    implementation("skin.support:skin-support:4.0.0") // 版本号请根据实际情况调整
    implementation("skin.support:skin-support-appcompat:4.0.0")

    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    implementation("com.jakewharton:butterknife:7.0.1")
    implementation("com.jakewharton:butterknife-compiler:7.0.1")

    implementation("com.jakewharton:butterknife:8.8.0")
    annotationProcessor("com.jakewharton:butterknife-compiler:8.8.0")




}