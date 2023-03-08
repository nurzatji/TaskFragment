package com.example.taskfragment.ui.notifications.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskfragment.databinding.ItemTaskBinding
import com.example.taskfragment.model.Quote
import com.example.taskfragment.model.Task

class QuoteAdapter() : RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {

    private val data = arrayListOf<Quote>()

    fun addQuote(quote: List<Quote>) {
        data.clear()
        data.addAll(quote)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder{
        return QuoteViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bind(data[position])

    }

    override fun getItemCount(): Int {
        return data.count()
    }

    inner class QuoteViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(quote: Quote) {
            itemView.setOnLongClickListener {

                false
            }
            with(binding) {
                title.text = quote.text
                description.text = quote.author

            }


        }
    }




}




