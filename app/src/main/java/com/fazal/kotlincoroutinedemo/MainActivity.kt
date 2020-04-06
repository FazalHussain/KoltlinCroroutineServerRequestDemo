package com.fazal.kotlincoroutinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fazal.kotlincoroutinedemo.di.ViewModelProviderFactory
import com.fazal.kotlincoroutinedemo.ui.user.UserViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)

        viewModel.user.observe(this, Observer {
            println(it.toString())
        })

        viewModel.setUserId("1")

    }
}
