package com.example.a5monthhomework2

import android.content.Context
import android.content.SharedPreferences
import com.example.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Modules {
    @Provides
    @Singleton
    fun getRepo(): Repository {
        return Repository(getApi())
    }

    @Provides
    @Singleton
    fun getApi(): CalculateApi {
        return getRetrofit().create(CalculateApi::class.java)
    }

    @Provides
    @Singleton
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Module
    @InstallIn(SingletonComponent::class)
     class SharedPreferencesModule {
        @Singleton
        @Provides
        fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
            return context.getSharedPreferences("preferences", Context.MODE_PRIVATE)
        }

    }}