package com.example.videomodule

import android.content.Context
import android.util.AttributeSet
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer

class SimplePlayer : StandardGSYVideoPlayer {
    constructor(context: Context):super(context){}
    constructor(context: Context, attrs: AttributeSet) :super(context,attrs){
    }
    override fun init(context: Context?) {
        super.init(context)
        hideAllWidget()
    }

}