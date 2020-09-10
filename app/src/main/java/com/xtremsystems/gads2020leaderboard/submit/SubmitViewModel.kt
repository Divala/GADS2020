package com.xtremsystems.gads2020leaderboard.submit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtremsystems.gads2020leaderboard.helpers.ApiHelper
import com.xtremsystems.gads2020leaderboard.helpers.ApiResult
import kotlinx.coroutines.launch

class SubmitViewModel : ViewModel() {
    val submit: MutableLiveData<Any> by lazy {
        MutableLiveData<Any>()
    }


    val errorMessage: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun submitProject(firstName: String, surname: String, email: String, link: String) {
        Log.d("SunError", firstName+surname+email+link)

        viewModelScope.launch {

            when (val retrofitPost = ApiHelper.submitProject(firstName, surname, email, link)) {
                is ApiResult.Success -> {
                    submit.postValue(retrofitPost.data)
                }
                is ApiResult.Error -> {
                    errorMessage.postValue(retrofitPost.exception)
                }
            }
        }
    }

}