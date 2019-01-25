package com.lenovo.kotlinvideo.ui.activity

import android.content.Intent
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.lenovo.kotlinvideo.R
import com.lenovo.kotlinvideo.adapter.FoodAdapter
import com.lenovo.kotlinvideo.bean.Food
import com.lenovo.kotlinvideo.mvp.presenter.FoodPresenter
import com.lenovo.kotlinvideo.mvp.view.FoodView
import com.lenovo.kotlinvideo.ui.base.BaseActivity
import com.example.videomodule.VideoActivity


class MainActivity : BaseActivity(), FoodView {
    private lateinit var reclerview: RecyclerView
    private var TAG: String = MainActivity::class.java.simpleName
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        reclerview = findViewById(R.id.recyclerView)
        reclerview.layoutManager = GridLayoutManager(this, 2)
        Log.i(TAG, "加载")
        findViewById<ImageView>(R.id.headerView).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.i(TAG, "点击头像")
                val intent=Intent(this@MainActivity,VideoActivity::class.java)
                startActivity(intent)
            }
        })
    }

    override fun initData() {
        var foodPresenter = FoodPresenter(this)
        foodPresenter.getFoodCatergry("584be421b1413d5eb0340d422d5b0d53", 1)
    }

    override fun onGetFoodMenuSuccess(foodBean: Food) {
        Log.i(TAG, "成功")
        var adapter = FoodAdapter(this, foodBean)
        reclerview.adapter = adapter
    }

    override fun onGetFoodMenuFailed(error: String) {
        Log.i(TAG, error)
    }
}
