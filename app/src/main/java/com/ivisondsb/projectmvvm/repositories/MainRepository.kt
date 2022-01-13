package com.ivisondsb.projectmvvm.repositories

import com.ivisondsb.projectmvvm.rest.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllLives() = retrofitService.getAllLives()

}