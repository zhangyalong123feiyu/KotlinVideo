package com.lenovo.kotlinvideo.mvp.presenter

import com.lenovo.kotlinvideo.bean.Food
import com.lenovo.kotlinvideo.bean.FoodBean
import com.lenovo.kotlinvideo.bean.FoodDetailBean
import com.lenovo.kotlinvideo.mvp.model.FoodModel
import com.lenovo.kotlinvideo.mvp.view.FoodView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodPresenterLife(foodView :FoodView) : BasePresenter(){
    private var view:FoodView
    private var foodModel:FoodModel?=null
    init {
        this.view=foodView
        foodModel= FoodModel()
    }

    override fun onCreate() {
        super.onCreate()
        getFoodCatergry("584be421b1413d5eb0340d422d5b0d53",1)
    }
    fun getFoodCatergry(key :String,cid:Int){
        foodModel!!.getFoodIndex(key,cid,object :Callback<Food>{
            override fun onFailure(call: Call<Food>, t: Throwable) {
                view.onGetFoodMenuFailed(t.message!!)
            }

            override fun onResponse(call: Call<Food>, response: Response<Food>) {
                var foodBean:Food = response.body()!!

                view.onGetFoodMenuSuccess(foodBean)
            }
        })
    }

}