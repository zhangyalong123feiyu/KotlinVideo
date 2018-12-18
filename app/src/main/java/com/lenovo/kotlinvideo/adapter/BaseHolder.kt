package com.lenovo.kotlinvideo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.lenovo.kotlinvideo.R

class BaseHolder(itemView:View ) : RecyclerView.ViewHolder(itemView) {

    var itView : View?=null
    var sparseArray:SparseArray<View>?=null

    init {
        this.itView=itemView
        sparseArray= SparseArray()
    }

    companion object {
         fun  <T : BaseHolder > getBaseHolder( context:Context, parent: ViewGroup, layoutId: Int) : T {
             return  BaseHolder(LayoutInflater.from(context).inflate(layoutId,parent,false)) as T
         }
    }

    //获取view
    fun <T : View> getView(id : Int) :T{
        itView=sparseArray!!.get(id)
        if (itView==null){
            itView=itemView.findViewById(id)
            sparseArray!!.put(id,itView)
        }
        return itView as T
    }
    //设置点击事件
    open fun  setOnclickListioner(id : Int){
        getView<View>(id).setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

            }
        })
    }

    //设置textview
   open  fun setTextView(id: Int,descrip:String) : BaseHolder{
        getView<TextView>(id).setText(descrip)
        return this
    }

    //设置imageview
    fun setImageView(id: Int,url:String) :BaseHolder{
        Glide.with(itView!!.context).load(url).into(getView(id))
        return this
    }
    fun setImageView(id: Int,res:Int):BaseHolder{
        getView<ImageView>(id).setImageResource(res)
        return this
    }
}