package com.example.a_hashimoto.dagger2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

//    @Inject
    lateinit var apiService: GithubApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiService = ApiServiceFactory.create()

        apiService.listRepos("a-hashimoto")
                .enqueue(object :Callback<List<Repo>>{
                    override fun onFailure(call: Call<List<Repo>>?, t: Throwable?) {
                        Log.d("listRepos", t.toString())
                    }

                    override fun onResponse(call: Call<List<Repo>>?, response: Response<List<Repo>>?) {
                        Log.d("listRepos", response.toString())
                    }
                })
    }
}
