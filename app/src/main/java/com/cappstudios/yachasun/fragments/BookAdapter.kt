package com.cappstudios.yachasun.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.cappstudios.yachasun.R
import kotlinx.android.synthetic.main.card_view_book.view.*
import kotlinx.android.synthetic.main.fragment_level_1.view.*
import java.util.*

class BookAdapter (
    private val data: List<BookObject>
): RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    private val items: MutableList<CardView>

    init {
        this.items = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_book, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = data[position].title

        items.add(holder.card)
    }

    override fun getItemCount(): Int {
        return data.size
    }
    inner class ViewHolder
    internal constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.textViewTitleBook
        val card: CardView = itemView.card
    }
}