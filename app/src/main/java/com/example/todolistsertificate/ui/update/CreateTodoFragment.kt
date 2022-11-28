package com.example.todolistsertificate.ui.update

import androidx.fragment.app.Fragment
import com.example.todolistsertificate.R
import com.example.todolistsertificate.databinding.FragmentUpdateBinding
import com.example.todolistsertificate.presenter.CreateTodoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateTodoFragment : Fragment(R.layout.fragment_update) {
    private lateinit var binding: FragmentUpdateBinding
    private val viewModel by viewModel<CreateTodoViewModel>()
}