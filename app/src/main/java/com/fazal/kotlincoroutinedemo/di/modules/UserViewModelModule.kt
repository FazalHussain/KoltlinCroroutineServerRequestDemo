package com.fazal.kotlincoroutinedemo.di.modules

import androidx.lifecycle.ViewModel
import com.fazal.kotlincoroutinedemo.di.ViewModelKey
import com.fazal.kotlincoroutinedemo.ui.user.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class UserViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindUserViewModel(userViewModel: UserViewModel) : ViewModel
}