package com.example.a5monthhomework2.app

import android.app.Application
import com.example.a5monthhomework2.CalculateApi
import com.example.a5monthhomework2.RetrofitService

class App: Application() {
  companion object {
      lateinit var api: CalculateApi
  }

    override fun onCreate() {
        super.onCreate()
        val retrofit = RetrofitService()
        api = retrofit.getApi()
    }
}
