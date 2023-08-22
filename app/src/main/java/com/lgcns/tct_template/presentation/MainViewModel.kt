package com.lgcns.tct_template.presentation

import android.app.Application
import androidx.lifecycle.*
import com.lgcns.tct_template.data.DataSource
import com.lgcns.tct_template.data.TctPreference
import com.lgcns.tct_template.data.TctService
import com.lgcns.tct_template.data.model.UserData
import com.lgcns.tct_template.data.model.UserListResponse
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import timber.log.Timber

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val api: TctService = DataSource.service

    private val _userListResponse = MutableLiveData<UserListResponse>()
    val userListResponse: LiveData<UserListResponse> get() = _userListResponse

    private val tctPreference by lazy { TctPreference(this.getApplication()) }

    fun fetchUserList() {
        viewModelScope.launch {
//            val response = api.getUsers()
            val mock = """{
    "userList": [
        {
            "id": 1,
            "name": "홍길동1",
            "phone_number": "01040055015",
            "age": 11,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile1.png"
        },
        {
            "id": 2,
            "name": "홍길동2",
            "phone_number": "01040055015",
            "age": 12,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile2.png"
        },
        {
            "id": 3,
            "name": "홍길동3",
            "phone_number": "01040055015",
            "age": 13,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile3.png"
        },
        {
            "id": 4,
            "name": "홍길동4",
            "phone_number": "01040055015",
            "age": 13,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile4.png"
        },
        {
            "id": 5,
            "name": "홍길동5",
            "phone_number": "01040055015",
            "age": 15,
            "address": "경기도 부천시 조마루로 271 미리내마을 937동 2601호",
            "imgPath": "thumb_profile5.png"
        },
        {
            "id": 6,
            "name": "홍길동6",
            "phone_number": "01040055015",
            "age": 16,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile6.png"
        },
        {
            "id": 7,
            "name": "홍길동7",
            "phone_number": "01040055015",
            "age": 17,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile7.png"
        },
        {
            "id": 1,
            "name": "홍길동1",
            "phone_number": "01040055015",
            "age": 11,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile1.png"
        },
        {
            "id": 2,
            "name": "홍길동2",
            "phone_number": "01040055015",
            "age": 12,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile2.png"
        },
        {
            "id": 3,
            "name": "홍길동3",
            "phone_number": "01040055015",
            "age": 13,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile3.png"
        },
        {
            "id": 4,
            "name": "홍길동4",
            "phone_number": "01040055015",
            "age": 13,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile4.png"
        },
        {
            "id": 5,
            "name": "홍길동5",
            "phone_number": "01040055015",
            "age": 15,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile5.png"
        },
        {
            "id": 6,
            "name": "홍길동6",
            "phone_number": "01040055015",
            "age": 16,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile6.png"
        },
        {
            "id": 7,
            "name": "홍길동7",
            "phone_number": "01040055015",
            "age": 17,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile7.png"
        },
        {
            "id": 1,
            "name": "홍길동1",
            "phone_number": "01040055015",
            "age": 11,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile1.png"
        },
        {
            "id": 2,
            "name": "홍길동2",
            "phone_number": "01040055015",
            "age": 12,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile2.png"
        },
        {
            "id": 3,
            "name": "홍길동3",
            "phone_number": "01040055015",
            "age": 13,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile3.png"
        },
        {
            "id": 4,
            "name": "홍길동4",
            "phone_number": "01040055015",
            "age": 13,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile4.png"
        },
        {
            "id": 5,
            "name": "홍길동5",
            "phone_number": "01040055015",
            "age": 15,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile5.png"
        },
        {
            "id": 6,
            "name": "홍길동6",
            "phone_number": "01040055015",
            "age": 16,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile6.png"
        },
        {
            "id": 7,
            "name": "홍길동7",
            "phone_number": "01040055015",
            "age": 17,
            "address": "서울특별시 강서구 마곡중앙8로 71",
            "imgPath": "thumb_profile7.png"
        }
    ]
}"""
            val response = DataSource.customJson.decodeFromString<UserListResponse>(mock)
            _userListResponse.postValue(response)

            tctPreference.put("userList", DataSource.customJson.encodeToString(response.userList))

            val decodeTest = DataSource.customJson.decodeFromString<List<UserData>>(
                tctPreference.getString(
                    "userList",
                    ""
                )
            )
            Timber.e("moong\n${decodeTest}")
        }
    }
}