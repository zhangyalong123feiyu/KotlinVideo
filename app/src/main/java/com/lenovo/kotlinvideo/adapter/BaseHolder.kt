package com.lenovo.kotlinvideo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class BaseHolder(itemView:View,layoutId:Int) : RecyclerView.ViewHolder(itemView) {

    var itView : View?=null
    var sparseArray:SparseArray<View>?=null

    init {
        this.itView=itemView
        sparseArray= SparseArray()
    }

    companion object {
         fun  <T : BaseHolder > getBaseHolder(context:Context, parent: ViewGroup,layoutId: Int) : T {
             return <T> BaseHolder(LayoutInflater.from(context).inflate(layoutId,parent,false))
         }
    }

}