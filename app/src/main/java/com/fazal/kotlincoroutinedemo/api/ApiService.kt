package com.fazal.kotlincoroutinedemo.api

import com.fazal.kotlincoroutinedemo.models.User
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Interface for defining API endpoints
 */
interface ApiService {

    @GET("placeholder/user/{userId}")
    suspend fun getUser(@Path("userId") userId: String) : User
}