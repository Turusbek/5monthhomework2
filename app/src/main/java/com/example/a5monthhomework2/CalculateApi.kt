package com.example.a5monthhomework2

import com.example.a5monthhomework2.model.CalculateModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CalculateApi {


    @GET("getPercentage")
    fun getPercentage(
        @Query("sname") secondName: String,
        @Query("fname") firstName: String,
        @Header("X-RapidAPI-Key") key: String ="018edc51c1mshb117e9da4daae38p17734fjsn25b9109b0cf1",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ): Call<CalculateModel>
}