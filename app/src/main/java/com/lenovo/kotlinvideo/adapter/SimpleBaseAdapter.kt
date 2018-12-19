package com.lenovo.kotlinvideo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

 abstract class SimpleBaseAdapter<T>(context: Context,listData:List<T>,layoutId:Int) : RecyclerView.Adapter<BaseHolder>() {
    private var context:Context
    private var listData:List<T>
    private var layoutId:Int
    init {
        this.context=context
        this.listData=listData
        this.layoutId=layoutId
    }
    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): BaseHolder {
      return  BaseHolder.getBaseHolder(context,p0,layoutId)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(p0: BaseHolder, p1: Int) {
        onBindData(p0,listData.get(p1),p1)
    }

     //bind数据方法，让子类实现
     abstract fun onBindData(baseHolder: BaseHolder, t:T, position: Int)


 }