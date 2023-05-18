package com.lgcns.tct_template.data

import com.lgcns.tct_template.data.model.UserItemResponse
import com.lgcns.tct_template.data.model.UserListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface TctService {

    @GET("/users")
    suspend fun getUsers(): UserListResponse

    @GET("/users/{id}")
    suspend fun getUser(@Path("id") userId: Long): UserItemResponse
}