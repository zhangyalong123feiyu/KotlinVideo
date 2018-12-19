package com.lenovo.kotlinvideo.mvp.model

import com.lenovo.kotlinvideo.api.FoodApi
import com.lenovo.kotlinvideo.bean.Food
import com.lenovo.kotlinvideo.bean.FoodBean
import com.lenovo.kotlinvideo.bean.FoodDetailBean
import com.lenovo.kotlinvideo.utils.RetrofitUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodModel{

     fun  getFoodCategory(key :String ,callback: Callback<FoodBean>) {
         var foodApi=RetrofitUtils.createRequest(FoodApi::class.java)
         foodApi.getFoodMenu("584be421b1413d5eb0340d422d5b0d53").enqueue(callback)
    }

    fun  getFoodIndex(key :String ,cid:Int ,callback: Callback<Food>) {
        var foodApi=RetrofitUtils.createRequest(FoodApi::class.java)
        foodApi.getFoodIndex("584be421b1413d5eb0340d422d5b0d53",cid).enqueue(callback)
    }

    fun getFoodDetail(id:String,key :String ,callback: Callback<FoodDetailBean>){
        var foodApi=RetrofitUtils.createRequest(FoodApi::class.java)
        foodApi.getFoodDetail(id,key).enqueue(callback)
    }
}
