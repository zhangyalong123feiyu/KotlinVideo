package com.lenovo.kotlinvideo.mvp.view

import com.lenovo.kotlinvideo.bean.FoodDetailBean

interface FoodDetailView {
    fun getFoodDetailSucess(listData:List<FoodDetailBean.ResultBean.DataBean>);
    fun getFoodDettailFailed(errMsg:String)
}