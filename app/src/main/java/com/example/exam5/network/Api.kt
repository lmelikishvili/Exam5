package com.example.exam5.network

import com.example.exam5.cource.Course
import retrofit2.http.GET

interface Api {
    @GET("83160a49-fe85-46ba-bcf8-3cf5aa09f92b")
    suspend fun getUsers(): retrofit2.Response<Course>
}