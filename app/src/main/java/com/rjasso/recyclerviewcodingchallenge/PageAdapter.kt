package com.rjasso.recyclerviewcodingchallenge

import Cards
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.page_item.view.*


class PageAdapter(val cards: ArrayList<Cards>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val CARD_TYPE_TEXT = "text"
    private val CARD_TYPE_TITLE_DESCRIPTION = "title_description"
    private val CARD_TYPE_IMAGE_TITLE_DESCRIPTION = "image_title_description"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.page_item, parent, false)
        return PageViewHolder(view)
    }

    override fun getItemCount() = cards.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val card = cards[position]
        if (card.card_type.equals(CARD_TYPE_TEXT)) {
            holder.itemView.valueTextView.text = card?.card?.value
            card?.card?.attributes?.text_color?.let { holder.itemView.valueTextView.setTextColor(Color.parseColor(it)) }
            card?.card?.attributes?.font?.size?.let { holder.itemView.valueTextView.textSize = it.toFloat() }

            // Hide unused views
            holder.itemView.titleTextView.visibility = View.GONE
            holder.itemView.descriptionTextView.visibility = View.GONE

            // Display views
            holder.itemView.valueTextView.visibility = View.VISIBLE
        }


        if (card.card_type.equals(CARD_TYPE_TITLE_DESCRIPTION)) {
            holder.itemView.titleTextView.text = card?.card?.title?.value
            card?.card?.title?.attributes?.text_color?.let { holder.itemView.titleTextView.setTextColor(Color.parseColor(it)) }
            card?.card?.title?.attributes?.font?.size?.let {
                holder.itemView.titleTextView.textSize = it.toFloat()
            }

            holder.itemView.descriptionTextView.text = card?.card?.description?.value
            card?.card?.description?.attributes?.text_color?.let { holder.itemView.titleTextView.setTextColor(Color.parseColor(it)) }
            card?.card?.description?.attributes?.font?.size?.let {
                holder.itemView.descriptionTextView.textSize = it.toFloat()
            }

            // Display views
            holder.itemView.titleTextView.visibility = View.VISIBLE
            holder.itemView.descriptionTextView.visibility = View.VISIBLE

            // Hide unused views
            holder.itemView.valueTextView.visibility = View.GONE
        }


        if (card.card_type.equals(CARD_TYPE_IMAGE_TITLE_DESCRIPTION)) {
            holder.itemView.titleTextView.text = card?.card?.title?.value
            card?.card?.title?.attributes?.text_color?.let { holder.itemView.titleTextView.setTextColor(Color.parseColor(it)) }
            card?.card?.title?.attributes?.font?.size?.let {
                holder.itemView.titleTextView.textSize = it.toFloat()
            }

            holder.itemView.descriptionTextView.text = card?.card?.description?.value
            card?.card?.description?.attributes?.text_color?.let { holder.itemView.descriptionTextView.setTextColor(Color.parseColor(it)) }
            card?.card?.description?.attributes?.font?.size?.let { holder.itemView.descriptionTextView.textSize = it.toFloat() }

            card?.card?.image?.url?.let {
                // TODO: Fix dynamic size
//                val sizeWidth = card?.card?.image?.size?.width ?: 1000
//                val sizeHeight = card?.card?.image?.size?.height ?: 1000
                Glide.with(holder.itemView.context)
                    .load(it)
//                    .override(sizeWidth, sizeHeight)
                    .listener(object : RequestListener<Drawable?> {
                        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable?>?, isFirstResource: Boolean): Boolean {
                            TODO("Not yet implemented")
                        }

                        override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable?>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                            holder.itemView.background = resource
                            return false
                        }

                    })
                    .submit()
            }

            // Display views
            holder.itemView.titleTextView.visibility = View.VISIBLE
            holder.itemView.descriptionTextView.visibility = View.VISIBLE

            // Hide unused views
            holder.itemView.valueTextView.visibility = View.GONE
        }


    }

    class PageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
