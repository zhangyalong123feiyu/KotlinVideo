package com.lenovo.kotlinvideo.adapter.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

abstract class MutualBaseAdapter<T>(context: Context, listData: List<T>, layoutIds: IntArray) : RecyclerView.Adapter<BaseHolder>() {
    private var context: Context
    private var listaData: List<T>
    private var layoutIds: IntArray

    init {
        this.context = context
        this.listaData = listData
        this.layoutIds = layoutIds
    }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): BaseHolder {
        return BaseHolder.getBaseHolder(context, parent, layoutIds[type])
    }

    override fun getItemCount(): Int {
        return listaData.size
    }

    override fun onBindViewHolder(p0: BaseHolder, p1: Int) {
        onBindData(p0,listaData[p1],p1)
    }

    //the abstrcat method for child class
    abstract fun onBindData(baseHolder: BaseHolder, t: T, position: Int)

}