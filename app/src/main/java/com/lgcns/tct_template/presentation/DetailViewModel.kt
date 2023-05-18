package com.lgcns.tct_template.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lgcns.tct_template.data.DataSource
import com.lgcns.tct_template.data.TctService
import com.lgcns.tct_template.data.model.UserData
import com.lgcns.tct_template.data.model.UserItemResponse
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {

    private val api: TctService = DataSource.service

    private val _userData = MutableLiveData<UserData>()
    val userData: LiveData<UserData> get() = _userData


    fun fetchFromNetwork(userId: Long) {
        viewModelScope.launch {
            val response: UserItemResponse = api.getUser(userId)
            _userData.postValue(response.user)
        }
    }


}