package com.example.a5monthhomework2.model

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    var repository: Repository, private val prefs:
    SharedPreferences
) : ViewModel() {

    fun getRequest(firstName: String, secondName: String): LiveData<CalculateModel> {
        return repository.getRequest(firstName, secondName)
    }
    fun saveBoardState(){
        prefs.edit().putBoolean("isShow",true).apply()
    }
    fun isBoardShow(): Boolean{
        return prefs.getBoolean("isShow",false)
    }
}