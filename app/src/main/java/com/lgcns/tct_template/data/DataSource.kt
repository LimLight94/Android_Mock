package com.lgcns.tct_template.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import logcat.logcat
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

@OptIn(ExperimentalSerializationApi::class)
object DataSource {

    private val customJson = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
        isLenient = true
        coerceInputValues = true
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor { message ->
                logcat { message }
            }.apply {
                this.setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        )
        .build()

    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl("https://7909ff6c-3334-4d44-b467-127e19a6fe8e.mock.pstmn.io/")
        .addConverterFactory(
            customJson.asConverterFactory("application/json".toMediaType())
        )
        .build()

    val service: TctService by lazy {
        retrofit.create(TctService::class.java)
    }
}
