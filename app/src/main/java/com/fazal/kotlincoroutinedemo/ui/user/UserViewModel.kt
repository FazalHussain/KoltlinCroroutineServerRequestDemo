package com.fazal.kotlincoroutinedemo.ui.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.fazal.kotlincoroutinedemo.models.User
import com.fazal.kotlincoroutinedemo.repo.UserRepo
import javax.inject.Inject

/**
 * User View Model is responsible for life cycler change event
 */
class UserViewModel @Inject constructor(private val userRepo: UserRepo) : ViewModel() {
    private val _userId = MutableLiveData<String>()

    val user = Transformations.switchMap(_userId) {
        userRepo.getUser(it)
    }

    fun setUserId(userId: String) {
        if (userId == _userId.value) return
        _userId.value = userId
    }

    fun cancelJob() = userRepo.cancelJob()
}