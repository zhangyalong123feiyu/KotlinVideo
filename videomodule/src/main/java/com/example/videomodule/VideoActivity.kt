package com.example.videomodule

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.shuyu.gsyvideoplayer.GSYBaseActivityDetail
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer

@Route(path = "/videomodule/activity_video")
class VideoActivity : GSYBaseActivityDetail<SimplePlayer>() {
    private lateinit var detailPlayer: SimplePlayer
    private val url="http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4"
    override fun clickForFullScreen() {

    }

    override fun getDetailOrientationRotateAuto(): Boolean {
       return true
    }

    override fun getGSYVideoPlayer(): SimplePlayer {
       return detailPlayer
    }

    override fun getGSYVideoOptionBuilder(): GSYVideoOptionBuilder {
        //内置封面可参考SampleCoverVideo
        val imageView = ImageView(this)
//        loadCover(imageView, "")
        return GSYVideoOptionBuilder()
                .setThumbImageView(imageView)
                .setUrl(url)
                .setCacheWithPlay(true)
                .setVideoTitle(" ")
                .setIsTouchWiget(true)
                .setRotateViewAuto(false)
                .setLockLand(false)
                .setShowFullAnimation(false)
                .setNeedLockFull(true)
                .setSeekRatio(1f)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
//        var testValue = intent.getIntExtra("testValue", 0)
//        findViewById<TextView>(R.id.testId).text=testValue.toString()

        detailPlayer = findViewById (R.id.detail_player)
        //增加title
        detailPlayer.getTitleTextView().setVisibility(View.GONE)
        detailPlayer.getBackButton().setVisibility(View.GONE)
        initVideoBuilderMode()
    }
}