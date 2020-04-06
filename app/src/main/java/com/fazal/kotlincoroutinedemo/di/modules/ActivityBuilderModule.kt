package com.fazal.kotlincoroutinedemo.di.modules

import com.fazal.kotlincoroutinedemo.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [UserViewModelModule::class])
    abstract fun contributeMainActivity(): MainActivity
}