package com.example.a5monthhomework2.model

import com.google.gson.annotations.SerializedName

data class CalculateModel (
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    val percentage : String,
    val result: String
        )

