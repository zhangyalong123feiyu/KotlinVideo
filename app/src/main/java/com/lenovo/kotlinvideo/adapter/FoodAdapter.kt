package com.lenovo.kotlinvideo.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.lenovo.kotlinvideo.R
import com.lenovo.kotlinvideo.bean.FoodBean
import com.lenovo.kotlinvideo.ui.activity.ClassifyActivity

class FoodAdapter(context: Context?,foodData:FoodBean?) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    private var context: Context?=null
    private var foodData:FoodBean?=null
    init {
        this.context=context
        this.foodData=foodData
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.item_food,null);
        return ViewHolder(view);
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        Glide.with(context!!).load(R.mipmap.ic_launcher).into(viewHolder.imagePic!!)
        viewHolder.textName!!.text= foodData!!.result!![i].name
        Log.i("TAG","进入Binder")
        viewHolder.imagePic!!.setOnClickListener (object :View.OnClickListener{
            override fun onClick(v: View?) {
                Log.i("TAG","点击")
                var intent=Intent(context,ClassifyActivity::class.java)
                intent.putExtra("parentId", foodData!!.result!![i]!!.parentId!!)
                intent.putExtra("title",foodData!!.result!![i].name)
                context!!.startActivity(intent)
            }
        })
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
