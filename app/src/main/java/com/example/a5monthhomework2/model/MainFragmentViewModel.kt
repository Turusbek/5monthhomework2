package com.example.a5monthhomework2.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.Repository

class MainFragmentViewModel : ViewModel() {

    val repository = Repository()

    fun getRequest(firstName: String,secondName: String):LiveData<CalculateModel>{
       return repository.getRequest(firstName,secondName)
    }
}