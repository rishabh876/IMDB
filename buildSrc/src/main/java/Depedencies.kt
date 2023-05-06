private object Dep {
  val NAVIGATION_COMP_VER = "2.5.3"
  val NAVIGATION_FRAGMENT_LIB = "androidx.navigation:navigation-fragment-ktx:$NAVIGATION_COMP_VER"
  val NAVIGATION_UI_LIB = "androidx.navigation:navigation-ui-ktx:$NAVIGATION_COMP_VER"
  val NAVIGATION_PLUGIN = "androidx.navigation:navigation-safe-args-gradle-plugin:$NAVIGATION_COMP_VER"

  val MATERIAL_VER = "1.8.0"
  val MATERIAL_LIB = "com.google.android.material:material:$MATERIAL_VER"

  val CONSTRAINT_LAYOUT_VER = "2.1.4"
  val CONSTRAINT_LAYOUT_LIB = "androidx.constraintlayout:constraintlayout:$CONSTRAINT_LAYOUT_VER"

  val CORE_KTX_VER = "1.10.0"
  val CORE_KTX_LIB = "androidx.core:core-ktx:$CORE_KTX_VER"

//  val ROOMS_VER = "2.5.1"
//  val ROOMS_LIB = "androidx.room:room-runtime:$ROOMS_VER"
//  val ROOMS_COROUTINE_LIB = "androidx.room:room-ktx:$ROOMS_VER"
//  val ROOMS_COMPILER_LIB = "androidx.room:room-compiler:$ROOMS_VER"

  val RECYCLERVIEW_VER = "1.3.0"
  val RECYCLERVIEW_LIB = "androidx.recyclerview:recyclerview:$RECYCLERVIEW_VER"

  val LIFECYCLE_VER = "2.6.1"
  val LIFECYCLE_LIVE_DATA_LIB = "androidx.lifecycle:lifecycle-livedata-ktx:$LIFECYCLE_VER"
  val LIFECYCLE_VIEW_MODEL_LIB = "androidx.lifecycle:lifecycle-viewmodel-ktx:$LIFECYCLE_VER"
  val LIFECYCLE_COMPILER = "androidx.lifecycle:lifecycle-compiler:$LIFECYCLE_VER"
  val LIFECYCLE_VIEW_MODEL_SAVED_STATE_LIB = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$LIFECYCLE_VER"

  val HILT_VER = "2.44"
  val HILT_LIBRARY = "com.google.dagger:hilt-android:$HILT_VER"
  val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:$HILT_VER"

  val COROUTINE_VER = "1.3.9"
  val COROUTINE_LIB = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$COROUTINE_VER"

  val GSON_VER = "2.9.0"
  val GSON_LIB = "com.google.code.gson:gson:$GSON_VER"

  val GLIDE_VER = "4.15.1"
  val GLIDE_LIB = "com.github.bumptech.glide:glide:$GLIDE_VER"

  // optional - Test helpers for LiveData
  //testImplementation "androidx.arch.core:core-testing:$arch_version"

  // optional - Test helpers for Lifecycle runtime
  //testImplementation "androidx.lifecycle:lifecycle-runtime-testing:$lifecycle_version"
}