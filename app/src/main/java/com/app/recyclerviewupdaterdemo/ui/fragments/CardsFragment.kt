package com.app.recyclerviewupdaterdemo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.app.recyclerviewupdaterdemo.databinding.FragmentCardsBinding
import com.app.recyclerviewupdaterdemo.ui.adapters.CardsAdapter
import com.app.recyclerviewupdaterdemo.utils.ColorListUtils
import kotlinx.coroutines.launch

class CardsFragment : Fragment() {

    private lateinit var binding: FragmentCardsBinding
    private val cardsAdapter = CardsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCardsBinding.inflate(layoutInflater, container, false)
        initList()
        initSearchbar()
        return binding.root
    }

    private fun initSearchbar() {
        binding.etSearchInput.addTextChangedListener {
            cardsAdapter.search(it.toString())
        }
    }

    private fun initList() {
        binding.recyclerView.adapter = cardsAdapter
        lifecycleScope.launch {
            ColorListUtils.getColorList(requireContext()).let {
                cardsAdapter.list = it
            }
        }
    }

    companion object {
        private const val TAG = "CardsFragment"
    }


}