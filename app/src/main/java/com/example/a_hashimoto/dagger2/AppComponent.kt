package com.example.a_hashimoto.dagger2

import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent{

    fun inject(activity: MainActivity)
}