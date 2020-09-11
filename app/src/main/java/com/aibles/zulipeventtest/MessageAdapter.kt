package com.aibles.zulipeventtest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aibles.zulipeventtest.databinding.ItemMessageBinding
import java.util.concurrent.Executors

class MessageAdapter: ListAdapter<MessageResponse, MessageAdapter.ViewHolder>(
    AsyncDifferConfig.Builder(
        MessageDiffCallback()
    ).setBackgroundThreadExecutor(Executors.newSingleThreadExecutor()).build()) {

    class ViewHolder private constructor(private val binding: ItemMessageBinding)
        :RecyclerView.ViewHolder(binding.root){

        fun bind(message: MessageResponse){
            binding.message = message

            binding.executePendingBindings()
        }

        companion object{
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMessageBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(
                    binding
                )
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = getItem(position)
        holder.bind(message)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)

}

class MessageDiffCallback: DiffUtil.ItemCallback<MessageResponse>(){
    override fun areItemsTheSame(oldItem: MessageResponse, newItem: MessageResponse): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MessageResponse, newItem: MessageResponse): Boolean =
        oldItem == newItem

}