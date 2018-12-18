package com.lenovo.kotlinvideo.mvp.presenter

import com.lenovo.kotlinvideo.bean.FoodBean
import com.lenovo.kotlinvideo.bean.FoodDetailBean
import com.lenovo.kotlinvideo.mvp.model.FoodModel
import com.lenovo.kotlinvideo.mvp.view.FoodView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodPresenter(foodView :FoodView) {
    private var view:FoodView
    private var foodModel:FoodModel?=null
    init {
        this.view=foodView
        foodModel= FoodModel()
    }

    fun getFoodCatergry(key :String){
        foodModel!!.getFoodCategory(key,object :Callback<FoodBean>{
            override fun onFailure(call: Call<FoodBean>, t: Throwable) {
                view.onGetFoodMenuFailed(t.message!!)
            }

            override fun onResponse(call: Call<FoodBean>, response: Response<FoodBean>) {
                var foodBean:FoodBean = response.body()!!

                view.onGetFoodMenuSuccess(foodBean)
            }
        })
    }

}