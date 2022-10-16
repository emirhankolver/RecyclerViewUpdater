package com.app.recyclerviewupdaterdemo.ui.adapters

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.ColorUtils
import androidx.recyclerview.widget.RecyclerView
import com.app.recyclerviewupdaterdemo.databinding.ListItemCardBinding
import com.emirhankolver.rvu.RecyclerViewUpdater

class CardsAdapter : RecyclerView.Adapter<CardsAdapter.VH>() {

    private var recyclerView: RecyclerView? = null
    var list = mutableListOf<Triple<String, String, Int>>()
        set(value) {
            field = value.toMutableList()
            filteredList = value.toMutableList()
        }

    var filteredList = mutableListOf<Triple<String, String, Int>>()
        set(value) {
            val instance = recyclerView?.layoutManager?.onSaveInstanceState()
            RecyclerViewUpdater(
                field,
                value,
                { oldData, newData -> oldData.first == newData.first },
                { oldData, newData -> oldData.second == newData.second }
            ).updateList(this)
            // This will prevent the RecyclerView from moving its position.
            if (instance != null) recyclerView!!.layoutManager!!.onRestoreInstanceState(instance)
        }


    fun search(searchStr: String) {
        if (searchStr.isEmpty()) {
            filteredList = list
            return
        }
        filteredList = list.toMutableList().filter {
            it.first.contains(searchStr, true)
        }.toMutableList()
    }

    class VH(val binding: ListItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(data: Triple<String, String, Int>) {
            binding.text.text = data.first
            binding.text.setTextColor(data.third)
            val lessAlpha = ColorUtils.setAlphaComponent(data.third,(0).toInt())
            binding.root.setCardBackgroundColor(Color.parseColor(data.second))
            binding.root.rippleColor = ColorStateList.valueOf(lessAlpha)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val lai = LayoutInflater.from(parent.context)
        return VH(ListItemCardBinding.inflate(lai, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.setData(filteredList[position])

    override fun getItemCount(): Int = filteredList.size

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    companion object {
        private const val TAG = "CardsAdapter"
    }
}