package com.lenovo.kotlinvideo.utils

import com.lenovo.kotlinvideo.utils.RetrofitUtils.lis.retrofit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtils{

    object lis{                                   //相当于Java中的静态声明,lis可以自取名字
        var retrofit:Retrofit ?=null
    }

    companion  object  {                         //相当于Java中的静态方法

        fun getRetrofit(): Retrofit {
            if (retrofit==null){
                synchronized(RetrofitUtils::class.java){
                    if (retrofit==null){
                        retrofit= Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("http://apis.juhe.cn/cook/").build()
                    }
                }
            }
        return retrofit!!

        }

        fun <T> createRequest(clas:Class<T>):T{
          var  clas= getRetrofit()!!.create(clas)
            return clas
        }
    }

}