package com.example.a_hashimoto.dagger2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

data class Repo(val name: String)

interface GithubApiService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<List<Repo>>
}