package com.rjasso.recyclerviewcodingchallenge

import PagesModel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PageViewModel : ViewModel() {
    private val repository: Repository = Repository()
    private val pages: MutableLiveData<PagesModel> by lazy {
        MutableLiveData<PagesModel> ().also {
            loadPages()
        }
    }

    fun getPages(): LiveData<PagesModel> {
        return pages
    }

    private fun loadPages() {
        repository.loadPagesFromAPI().enqueue(object: Callback<PagesModel> {
            override fun onFailure(call: Call<PagesModel>?, t: Throwable?) {
                t?.let { Log.d(PageViewModel::class.java.canonicalName, it?.message) }
            }

            override fun onResponse(call: Call<PagesModel>?, response: Response<PagesModel>?) {
                response?.body()?.let { pages.value = it }
            }
        })
    }
}