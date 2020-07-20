package com.rjasso.recyclerviewcodingchallenge

import PagesModel
import retrofit2.Call

class Repository {
    fun loadPagesFromAPI(): Call<PagesModel> {
        return RetrofitClient.instance.home()
    }

    fun loadPagesFromDatabase() {
        // TODO Create data base DAO
    }
}