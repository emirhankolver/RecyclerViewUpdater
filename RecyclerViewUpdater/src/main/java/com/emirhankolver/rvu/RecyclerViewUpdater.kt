package com.emirhankolver.rvu

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewUpdater<T : Any?>(
    private val oldList: MutableList<T>,
    private val newList: MutableList<T>,
    private val areItemsTheSame: (oldData: T, newData: T) -> Boolean,
    private val areContentsTheSame: (oldData: T, newData: T) -> Boolean
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return areItemsTheSame(oldList[oldItemPosition], newList[newItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return areContentsTheSame(oldList[oldItemPosition], newList[newItemPosition])
    }

    fun updateList(adapter: RecyclerView.Adapter<*>) = with(DiffUtil.calculateDiff(this)) {
        oldList.clear()
        oldList.addAll(newList)
        dispatchUpdatesTo(adapter)
    }
}