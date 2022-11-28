package com.example.todolistsertificate.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

import com.example.todolistsertificate.R
import com.example.todolistsertificate.databinding.FragmentAddListBinding
import com.example.todolistsertificate.presenter.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_add_list) {
    private lateinit var binding: FragmentAddListBinding
    private val viewModel by viewModel<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddListBinding.bind(view)

    }
}