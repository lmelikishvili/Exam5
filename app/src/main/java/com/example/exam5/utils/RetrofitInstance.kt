package com.example.exam5.utils

import com.example.exam5.network.Api
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val api: Api by lazy {
       Retrofit.Builder()
            .baseUrl(Utils.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(Api::class.java)
    }
}