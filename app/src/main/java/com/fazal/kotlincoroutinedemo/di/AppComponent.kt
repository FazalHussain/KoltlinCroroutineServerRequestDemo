package com.fazal.kotlincoroutinedemo.di

import android.app.Application
import com.fazal.kotlincoroutinedemo.BaseApplication
import com.fazal.kotlincoroutinedemo.di.modules.ActivityBuilderModule
import com.fazal.kotlincoroutinedemo.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import java.util.*
import javax.inject.Singleton

/**
 * Dagger can create a graph of the dependencies in your project that it can use to find out where
 * it should get those dependencies when they are needed. To make Dagger do this, you need to create
 * an interface and annotate it with @Component
 *
 *
 * Component will provide injected instances by using modules.
 * Extends appcomponent with [AndroidInjector] to avoid old way of injection application
 *
 * <code>
 *     fun inject(application: BaseApplication)
 * </code>
 *
 * AppComponent is act as a server whereas, [BaseApplication] act as a client.
 * Dagger interaction is like client-server interaction
 *
 * Anotated with [Singleton] Scope to tell dagger to keep it in the memory while application exists
 * and destroy it when application destroy
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuilderModule::class,
    AppModule::class,
    ViewModelFactoryModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {



    @Component.Builder
    interface Builder {

        /**
         * [BindsInstance] annotation is used for, if you want to bind particular object or instance
         * of an object through the time of component construction
         */
        @BindsInstance
        fun application(application: Application) : Builder

        fun build() : AppComponent
    }

}