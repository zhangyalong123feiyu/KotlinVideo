package com.lenovo.kotlinvideo.mvp.view

import com.lenovo.kotlinvideo.bean.Food
import com.lenovo.kotlinvideo.bean.FoodBean

interface FoodView {
    fun onGetFoodMenuSuccess(foodBean : Food)
    fun onGetFoodMenuFailed(error:String)
}