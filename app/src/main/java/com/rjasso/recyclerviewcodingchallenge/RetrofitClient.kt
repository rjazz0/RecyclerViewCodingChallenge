package com.rjasso.recyclerviewcodingchallenge

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val BASEURL = "https://private-8ce77c-tmobiletest.apiary-mock.com/test/"
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor{ chain ->
            val chainRequest = chain.request()
            val request = chainRequest.newBuilder().method(chainRequest.method(), chainRequest.body()).build()
            chain.proceed(request)
        }.build()
    val instance by lazy {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASEURL)
            .client(okHttpClient)
            .build()
        retrofit.create(PageAPI::class.java)
    }

}