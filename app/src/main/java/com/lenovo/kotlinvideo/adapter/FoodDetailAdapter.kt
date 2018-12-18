package com.lenovo.kotlinvideo.adapter

import android.content.Context
import com.lenovo.kotlinvideo.R
import com.lenovo.kotlinvideo.bean.FoodDetailBean

class FoodDetailAdapter (context: Context, listData:List<FoodDetailBean.ResultBean.DataBean>, layoutId:Int): SimpleBaseAdapter<FoodDetailBean.ResultBean.DataBean>(context, listData, layoutId){

    override fun onBindData(baseHolder: BaseHolder, t: FoodDetailBean.ResultBean.DataBean, position: Int) {
        baseHolder.setTextView(R.id.food_name,t.title!!).setImageView(R.id.food_pic,t.albums!!.get(0))
    }

}