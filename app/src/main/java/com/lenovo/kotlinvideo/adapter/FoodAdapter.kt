package com.lenovo.kotlinvideo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.lenovo.kotlinvideo.R
import com.lenovo.kotlinvideo.bean.FoodBean

class FoodAdapter(context: Context?,foodData:FoodBean?) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    private var context: Context?=null
    private var foodData:FoodBean?=null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.item_food,null);
        return ViewHolder(view);
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        Glide.with(context!!).load(R.mipmap.ic_launcher).into(viewHolder.imagePic!!)
        viewHolder.textName!!.text= foodData!!.result!![i].name
    }

    override fun getItemCount(): Int {
        return foodData!!.result!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
         var imagePic: ImageView ?=null
         var textName: TextView ?=null
        init {
            imagePic=itemView.findViewById(R.id.food_pic)
            textName=itemView.findViewById(R.id.food_name)
        }
    }
}
