package com.example.a_hashimoto.dagger2

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
open class AppModule {

    @Singleton
    @Provides
    open fun provideGithubApiService(): GithubApiService {

        val retrofit = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl("https://api.github.com/")
                .build()

        return retrofit.create<GithubApiService>(GithubApiService::class.java)
    }

}