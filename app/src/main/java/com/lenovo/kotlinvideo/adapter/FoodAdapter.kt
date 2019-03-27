package com.lenovo.kotlinvideo.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.lenovo.kotlinvideo.R
import com.lenovo.kotlinvideo.bean.Food
import com.lenovo.kotlinvideo.ui.activity.ClassifyActivity
import com.lenovo.kotlinvideo.utils.GlideApp

class FoodAdapter(context: Context, foodData: Food) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    private var context: Context
    private var foodData: Food

    init {
        this.context = context
        this.foodData = foodData
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_food, null);
        return ViewHolder(view);
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        GlideApp.with(context).load(foodData.result!!.data!![i].albums!!.get(0)).into(viewHolder.imagePic!!)
        viewHolder.textName!!.text = foodData.result!!.data!!.get(i).title
        viewHolder.imagePic!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                var intent = Intent(context, ClassifyActivity::class.java)
                intent.putExtra("parentId", foodData.result!!.data!!.get(i).id)
                intent.putExtra("title", foodData.result!!.data!!.get(i).title)
                context.startActivity(intent)
            }
        })
    }

    override fun getItemCount(): Int {
        return foodData.result!!.data!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imagePic: ImageView? = null
        var textName: TextView? = null

        init {
            imagePic = itemView.findViewById(R.id.food_pic)
            textName = itemView.findViewById(R.id.food_name)
        }

    }

}
