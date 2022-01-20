package com.ivisondsb.projectmvvm.viewmodel.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ivisondsb.projectmvvm.models.Lives
import com.ivisondsb.projectmvvm.repositories.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val liveList = MutableLiveData<List<Lives>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllLives() {

        val request = repository.getAllLives()
        request.enqueue(object : Callback<List<Lives>> {
            override fun onResponse(call: Call<List<Lives>>, response: Response<List<Lives>>) {

                liveList.postValue(response.body())

            }

            override fun onFailure(call: Call<List<Lives>>, t: Throwable) {

                errorMessage.postValue(t.message)

            }

        })
    }

}