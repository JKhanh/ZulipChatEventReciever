package com.aibles.zulipeventtest

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("app:items")
fun setItem(recyclerView: RecyclerView, entries: List<MessageResponse>?) {
    if (entries == null || recyclerView.adapter == null)
        return

    (recyclerView.adapter as MessageAdapter).submitList(
        entries
    )
}