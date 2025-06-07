package com.example.storyapp.data.remote

import com.example.storyapp.data.remote.model.`LoginRequest.kt`
import com.example.storyapp.data.remote.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body loginRequest: `LoginRequest.kt`): LoginResponse

    // Tambahkan endpoint lain di sini
}
