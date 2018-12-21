package com.lenovo.kotlinvideo.adapter

import android.content.Context
import com.lenovo.kotlinvideo.R
import com.lenovo.kotlinvideo.adapter.base.BaseHolder
import com.lenovo.kotlinvideo.adapter.base.SimpleBaseAdapter
import com.lenovo.kotlinvideo.bean.FoodDetailBean

class FoodDetailAdapter (context: Context, listData:List<FoodDetailBean.ResultBean.DataBean.StepsBean>, layoutId:Int): SimpleBaseAdapter<FoodDetailBean.ResultBean.DataBean.StepsBean>(context, listData, layoutId){

    override fun onBindData(baseHolder: BaseHolder, t: FoodDetailBean.ResultBean.DataBean.StepsBean, position: Int) {
        baseHolder.setTextView(R.id.food_step, t.step!!).setImageView(R.id.food_pic, t.img!!)
    }

}