package com.example.videomodule

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Environment
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.Toast
import java.io.File

class SurfcacePlayer :AppCompatActivity() {
    private lateinit var surfaceview:SurfaceView
    val serviceConnection=object :ServiceConnection{
        override fun onServiceDisconnected(name: ComponentName?) {

        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.i("TAG","bindService success")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surface)
        surfaceview=findViewById(R.id.surface_view)
        val surfaceHolder=surfaceview.holder
        surfaceHolder.addCallback(object :SurfaceHolder.Callback{
            override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {

            }

            override fun surfaceDestroyed(holder: SurfaceHolder?) {

            }

            override fun surfaceCreated(holder: SurfaceHolder?) {

            }
        })

        val mediaPlayer=MediaPlayer()
        val filePath=Environment.getExternalStorageDirectory().absolutePath+"/guangdavideo/video.mp4"
        val file=File(filePath)
        if (!file.exists()){
            Toast.makeText(this,"视频文件不存在",Toast.LENGTH_LONG).show()
            return
        }
        mediaPlayer.setDataSource(filePath)
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        mediaPlayer.prepareAsync()
        mediaPlayer.setOnPreparedListener(object : MediaPlayer.OnPreparedListener{
            override fun onPrepared(mp: MediaPlayer?) {
                mediaPlayer.setDisplay(surfaceHolder)
                mediaPlayer.start()
            }
        })
        val intent=Intent(this,RemoteService::class.java)

        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(serviceConnection)
    }
}