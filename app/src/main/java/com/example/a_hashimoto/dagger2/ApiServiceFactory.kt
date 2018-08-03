package com.example.a_hashimoto.dagger2

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiServiceFactory {
    var apiService: GithubApiService? = null

    fun create(): GithubApiService{
        if (apiService == null) {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(MoshiConverterFactory.create())
                    .baseUrl("https://api.github.com/")
                    .build()

            apiService = retrofit.create<GithubApiService>(GithubApiService::class.java)
        }
        return apiService!!
    }
}