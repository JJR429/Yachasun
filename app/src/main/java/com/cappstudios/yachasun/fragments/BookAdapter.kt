package com.cappstudios.yachasun.fragments

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.cappstudios.yachasun.R
import com.cappstudios.yachasun.ToRead
import kotlinx.android.synthetic.main.card_view_book.view.*
import java.util.*


class BookAdapter(
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
        holder.bookCover.setImageResource(R.drawable.medal_icon)
        val book_cod = data[position].cod_book
        Toast.makeText(holder.card.context, ("Index: $position"), Toast.LENGTH_SHORT).show()
        //here set data
        holder.card.setOnClickListener{
            val toread = Intent(holder.card.context, ToRead::class.java)
            toread.putExtra("index", position)
            toread.putExtra("cod_book", book_cod)
            holder.card.context.startActivity(toread)
        }
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
        val bookCover: ImageView = itemView.ImgBookCover
        val card: CardView = itemView.card
    }

}