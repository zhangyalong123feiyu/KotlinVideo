package com.lenovo.kotlinvideo.ui.activity

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.videomodule.IMyAidlInterface
import com.example.videomodule.RemoteService
import com.example.videomodule.SurfcacePlayer
import com.lenovo.kotlinvideo.R
import com.lenovo.kotlinvideo.adapter.FoodAdapter
import com.lenovo.kotlinvideo.bean.Food
import com.lenovo.kotlinvideo.mvp.view.FoodView
import com.lenovo.kotlinvideo.ui.base.BaseActivity
import com.lenovo.kotlinvideo.mvp.presenter.FoodPresenterLife

class MainActivity : BaseActivity(), FoodView {
    private lateinit var reclerview: RecyclerView
    private var TAG: String = MainActivity::class.java.simpleName
    private var adapter:FoodAdapter?=null
    private val serviceConnection= object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {

        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            var iService = IMyAidlInterface.Stub.asInterface(service)
            val result=iService.add(1,2)
            Log.i("TAG","计算结果是"+result)
        }

    }
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
                val intent = Intent(this@MainActivity, SurfcacePlayer::class.java)
                intent.putExtra("testValue", 23);
                bindRemoteService()
                startActivity(intent)
//                ARouter.getInstance().build("/videomodule/activity_video").navigation()
            }
        })

    }


    private fun bindRemoteService() {
        val intent=Intent(this,RemoteService::class.java)
//        bindService(intent,serviceConnection,Context.BIND_AUTO_CREATE)
    }

    override fun initData() {

        val foodP = FoodPresenterLife(this)
        lifecycle.addObserver(foodP)
    }

    override fun onGetFoodMenuSuccess(foodBean: Food) {
        Log.i(TAG, "成功")
        adapter = FoodAdapter(this, foodBean)
        reclerview.adapter = adapter
    }

    override fun onGetFoodMenuFailed(error: String) {
        Log.i(TAG, error)
    }
}
