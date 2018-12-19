package com.lenovo.kotlinvideo.ui.activity

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.lenovo.kotlinvideo.R
import com.lenovo.kotlinvideo.adapter.FoodAdapter
import com.lenovo.kotlinvideo.api.FoodApi
import com.lenovo.kotlinvideo.bean.Food
import com.lenovo.kotlinvideo.bean.FoodBean
import com.lenovo.kotlinvideo.mvp.presenter.FoodPresenter
import com.lenovo.kotlinvideo.mvp.view.FoodView
import com.lenovo.kotlinvideo.ui.base.BaseActivity
import retrofit2.*
import java.util.*

class MainActivity : BaseActivity(),FoodView {
    private lateinit var  reclerview : RecyclerView
    private var TAG:String=MainActivity::class.java.simpleName
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        reclerview=findViewById(R.id.recyclerView)
        reclerview.layoutManager=GridLayoutManager(this,2)
    }
    override fun initData() {
        var  foodPresenter=FoodPresenter(this)
        foodPresenter.getFoodCatergry("584be421b1413d5eb0340d422d5b0d53",1)
    }

    override fun onGetFoodMenuSuccess(foodBean: Food) {
        var adapter=FoodAdapter(this,foodBean)
        reclerview.adapter=adapter
    }

    override fun onGetFoodMenuFailed(error: String) {
        Log.i(TAG,error)
    }
}
