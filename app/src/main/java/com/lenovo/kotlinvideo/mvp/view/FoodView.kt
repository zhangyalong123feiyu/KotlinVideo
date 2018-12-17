package com.lenovo.kotlinvideo.mvp.view

import com.lenovo.kotlinvideo.bean.FoodBean

interface FoodView {
    fun onGetFoodMenuSuccess(foodBean : FoodBean)
    fun onGetFoodMenuFailed(error:String)
}