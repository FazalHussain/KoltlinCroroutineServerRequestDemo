package com.fazal.kotlincoroutinedemo.repo

import androidx.lifecycle.LiveData
import com.fazal.kotlincoroutinedemo.api.ApiService
import com.fazal.kotlincoroutinedemo.models.User
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import javax.inject.Inject

/**
 * User Repository Class
 */
class UserRepo @Inject constructor(val apiService: ApiService) {

    var job: CompletableJob? = null

    /**
     * get the user based on the user id. [CompletableJob] is used
     * to complete the job or cancel the job
     *
     * [LiveData.onActive] is used to tell the livedata is active
     */
    fun getUser(userId: String) : LiveData<User> {
        job = Job()
        return object : LiveData<User>() {
            override fun onActive() {
                super.onActive()
                job?.let { job ->
                    CoroutineScope(IO + job).launch {
                        try {
                            val user = apiService.getUser(userId)
                            withContext(Main) {
                                value = user
                                job.complete()
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }
            }
        }
    }

    /**
     * Cancel the job
     */
    fun cancelJob() {
        job?.cancel()
    }
}