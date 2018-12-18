package com.lenovo.kotlinvideo.mvp.presenter

import com.lenovo.kotlinvideo.bean.FoodDetailBean
import com.lenovo.kotlinvideo.mvp.model.FoodModel
import com.lenovo.kotlinvideo.mvp.view.FoodDetailView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodDetailPresenter(foodDetailView: FoodDetailView){
    private var foodDetailView:FoodDetailView?=null
    private var foodDetailModel:FoodModel?=null
    init {
        this.foodDetailView=foodDetailView
        this.foodDetailModel=FoodModel()
    }

    fun getFoodDetail(id:String,key:String){
        foodDetailModel!!.getFoodDetail(id,key,object : Callback<FoodDetailBean> {
            override fun onFailure(call: Call<FoodDetailBean>, t: Throwable) {
                foodDetailView!!.getFoodDettailFailed(t.message!!)
            }

            override fun onResponse(call: Call<FoodDetailBean>, response: Response<FoodDetailBean>) {
                var FoodDetailBean=response.body()
                foodDetailView!!.getFoodDetailSucess(FoodDetailBean!!.result!!.data!!)
            }
        })
    }
}
