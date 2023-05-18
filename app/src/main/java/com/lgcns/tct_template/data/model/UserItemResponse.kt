package com.lgcns.tct_template.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserItemResponse(

    @SerialName("user")
    val user: UserData

)