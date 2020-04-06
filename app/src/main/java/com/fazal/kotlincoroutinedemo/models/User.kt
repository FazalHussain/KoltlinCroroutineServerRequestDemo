package com.fazal.kotlincoroutinedemo.models

import com.google.gson.annotations.SerializedName

/**
 * User Data Class
 */
data class User (
    @SerializedName("username")
    val username: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("image")
    val imageURL: String

)