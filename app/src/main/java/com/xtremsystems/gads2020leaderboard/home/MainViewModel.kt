package com.xtremsystems.gads2020leaderboard.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtremsystems.gads2020leaderboard.data.LearnerHoursItem
import com.xtremsystems.gads2020leaderboard.data.LearnerSkillsItem
import com.xtremsystems.gads2020leaderboard.helpers.ApiHelper
import com.xtremsystems.gads2020leaderboard.helpers.ApiResult
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val learnerHours: MutableLiveData<List<LearnerHoursItem>> by lazy {
        MutableLiveData<List<LearnerHoursItem>>()
    }
    val learnerSkills: MutableLiveData<List<LearnerSkillsItem>> by lazy {
        MutableLiveData<List<LearnerSkillsItem>>()
    }


    val errorMessage: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun learnerHours() {

        viewModelScope.launch {

            when (val retrofitPost = ApiHelper.getLearnerHours()) {
                is ApiResult.Success -> {
                    learnerHours.postValue(retrofitPost.data)
                }
                is ApiResult.Error -> {
                    errorMessage.postValue(retrofitPost.exception)
                }
            }
        }
    }

    fun learnerSkills() {
        viewModelScope.launch {

            when (val retrofitPost = ApiHelper.getLearnerSkills()) {
                is ApiResult.Success -> {
                    learnerSkills.postValue(retrofitPost.data)
                }
                is ApiResult.Error -> {
                    errorMessage.postValue(retrofitPost.exception)
                }
            }
        }
    }
}