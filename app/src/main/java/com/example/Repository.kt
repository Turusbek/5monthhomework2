package com.example

import androidx.lifecycle.MutableLiveData
import com.example.a5monthhomework2.CalculateApi
import com.example.a5monthhomework2.model.CalculateModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: CalculateApi
) {
    fun getRequest(firstName: String, secondName: String): MutableLiveData<CalculateModel> {
        val calculateLiveData = MutableLiveData<CalculateModel>()
        api.getPercentage(firstName, secondName).enqueue(
            object : Callback<CalculateModel> {
                override fun onResponse(
                    call: Call<CalculateModel>,
                    response: Response<CalculateModel>
                ) {
                    calculateLiveData.postValue(response.body())
                }

                override fun onFailure(call: Call<CalculateModel>, t: Throwable) {
                }
            })
        return calculateLiveData
    }
}