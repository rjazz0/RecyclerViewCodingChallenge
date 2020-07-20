package com.rjasso.recyclerviewcodingchallenge

import PagesModel
import retrofit2.Call
import retrofit2.http.GET

interface PageAPI {
    @GET("home")
    fun home(): Call<PagesModel>
}