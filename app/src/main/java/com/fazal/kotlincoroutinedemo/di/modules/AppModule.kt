package com.fazal.kotlincoroutinedemo.di.modules

import com.fazal.kotlincoroutinedemo.api.ApiService
import com.fazal.kotlincoroutinedemo.models.User
import com.fazal.kotlincoroutinedemo.repo.UserRepo
import com.fazal.kotlincoroutinedemo.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * App Module is used to provide app level dependency
 */
@Module
class AppModule {

    @Singleton
    @Provides
    internal fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    internal fun provideAPIService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    internal fun provideUserRepo(apiService: ApiService): UserRepo {
        return UserRepo(apiService)
    }
}