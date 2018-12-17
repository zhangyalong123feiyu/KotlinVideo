package com.lenovo.kotlinvideo.ui.activity

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.lenovo.kotlinvideo.R
import com.lenovo.kotlinvideo.ui.base.BaseActivity

class ClassifyActivity :BaseActivity() {
    private var classRecy:RecyclerView?=null
    private var title:TextView?=null
    override fun getLayoutId(): Int {
        return R.layout.activity_classfiy
    }
    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initView() {
        title=findViewById(R.id.title)
        classRecy=findViewById(R.id.classfiyRecycl)
        var layoutManager=GridLayoutManager(this,4)
        classRecy!!.layoutManager=layoutManager
    }

}