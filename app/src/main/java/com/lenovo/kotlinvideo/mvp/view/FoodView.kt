package com.lenovo.kotlinvideo.mvp.view

interface FoodView {
    fun onGetFoodMenuSuccess(msg:String)
    fun onGetFoodMenuFailed(error:String)
}