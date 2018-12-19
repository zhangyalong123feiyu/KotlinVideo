package com.lenovo.kotlinvideo.ui.activity

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import com.lenovo.kotlinvideo.R
import com.lenovo.kotlinvideo.adapter.FoodDetailAdapter
import com.lenovo.kotlinvideo.bean.FoodBean
import com.lenovo.kotlinvideo.bean.FoodDetailBean
import com.lenovo.kotlinvideo.mvp.presenter.FoodDetailPresenter
import com.lenovo.kotlinvideo.mvp.presenter.FoodPresenter
import com.lenovo.kotlinvideo.mvp.view.FoodDetailView
import com.lenovo.kotlinvideo.mvp.view.FoodView
import com.lenovo.kotlinvideo.ui.base.BaseActivity

class ClassifyActivity :BaseActivity(),FoodDetailView{

    private var classRecy:RecyclerView?=null
    private var title:TextView?=null
    private var TAG:String?=ClassifyActivity::class.simpleName
    private var parentId: String?=null

    override fun getLayoutId(): Int {
        return R.layout.activity_classfiy
    }
    override fun initData() {
        var foodPresenter=FoodDetailPresenter(this)
        foodPresenter.getFoodDetail(parentId!!,"584be421b1413d5eb0340d422d5b0d53")
    }



    override fun initView() {
        title=findViewById(R.id.title)
        classRecy=findViewById(R.id.classfiyRecycl)
        var layoutManager= LinearLayoutManager(this)
        classRecy!!.layoutManager=layoutManager

        var content=intent.getStringExtra("title");
        parentId=intent.getStringExtra("parentId")
        title!!.text=content

    }

    override fun getFoodDetailSucess(listData: List<FoodDetailBean.ResultBean.DataBean.StepsBean>) {
       var foodDetailAdapter=FoodDetailAdapter(this,listData,R.layout.item_food_detail)
        classRecy!!.adapter=foodDetailAdapter
    }

    override fun getFoodDettailFailed(errMsg: String) {
        Log.i(TAG,errMsg)
    }


}