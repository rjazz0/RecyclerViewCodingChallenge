package com.rjasso.recyclerviewcodingchallenge

import Cards
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val cards = arrayListOf<Cards>()
    lateinit var viewModel: PageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pageRecyclerView.layoutManager = LinearLayoutManager(this)
        pageRecyclerView.setHasFixedSize(true)
        pageRecyclerView.adapter = PageAdapter(cards)
        pageRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        viewModel = ViewModelProvider(this).get(PageViewModel::class.java)

        viewModel.getPages().observe(this, Observer { response ->
            cards.clear()
            cards.addAll(response.page.cards)
            (pageRecyclerView.adapter as PageAdapter).notifyDataSetChanged()
        })
    }
}
