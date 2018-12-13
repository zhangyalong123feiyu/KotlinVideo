package com.lenovo.kotlinvideo.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

abstract class BaseFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView();
        initData();
    }

    abstract fun initData()

    abstract fun initView()
}