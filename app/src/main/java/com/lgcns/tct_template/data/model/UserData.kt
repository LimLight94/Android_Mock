package com.lgcns.tct_template.data.model

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class UserData (
    @SerialName("id")
    val id: Long,
    @SerialName("name")
    val name: String,
    @SerialName("phone_number")
    val phoneNum: String,
    @SerialName("age")
    val age: Int,
    @SerialName("address")
    val address: String,
    @SerialName("imgPath")
    var imageFile: String = ""
) : Parcelable {

    @IgnoredOnParcel
    var isExpanded: Boolean = false
}
