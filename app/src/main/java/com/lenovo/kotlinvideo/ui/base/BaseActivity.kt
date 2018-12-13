package com.lenovo.kotlinvideo.ui.base

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId());
        initView();
        initData();
    }

    abstract fun initData()

    abstract fun initView()

    abstract fun getLayoutId(): Int
}

