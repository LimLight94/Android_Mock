package com.lgcns.tct_template.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserListResponse(

    @SerialName("userList")
    val userList: List<UserData>

)