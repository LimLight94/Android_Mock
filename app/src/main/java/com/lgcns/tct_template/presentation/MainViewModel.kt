package com.lgcns.tct_template.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lgcns.tct_template.data.DataSource
import com.lgcns.tct_template.data.TctService
import com.lgcns.tct_template.data.model.UserListResponse
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val api: TctService = DataSource.service

    private val _userListResponse = MutableLiveData<UserListResponse>()
    val userListResponse: LiveData<UserListResponse> get() = _userListResponse

    fun fetchUserList() {
        viewModelScope.launch {
            val response = api.getUsers()
            _userListResponse.postValue(response)
        }
    }
}