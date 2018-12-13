package com.lenovo.kotlinvideo.api

import com.lenovo.kotlinvideo.bean.FoodBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApi {
    @GET("category")
    fun getFoodMenu(@Query("key") d:String) : Call<FoodBean>
}