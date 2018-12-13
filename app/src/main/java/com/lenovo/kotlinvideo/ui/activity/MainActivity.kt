package com.lenovo.kotlinvideo.ui.activity

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.lenovo.kotlinvideo.R
import com.lenovo.kotlinvideo.adapter.FoodAdapter
import com.lenovo.kotlinvideo.api.FoodApi
import com.lenovo.kotlinvideo.bean.FoodBean
import com.lenovo.kotlinvideo.ui.base.BaseActivity
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.create

class MainActivity : BaseActivity() {
    private var  reclerview : RecyclerView ?=null;
    private var foodData:FoodBean ?=null
    private var retrofit:Retrofit ?=null

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        reclerview=findViewById(R.id.recyclerView)
        reclerview?.layoutManager=LinearLayoutManager(this)
        var adapter=FoodAdapter(this,foodData)
        reclerview!!.adapter=adapter
    }
    override fun initData() {
        retrofit=Retrofit.Builder().baseUrl("").build()
        var foodApi=retrofit!!.create(FoodApi::class.java)
        foodApi.getFoodMenu("584be421b1413d5eb0340d422d5b0d53").
    }

}
