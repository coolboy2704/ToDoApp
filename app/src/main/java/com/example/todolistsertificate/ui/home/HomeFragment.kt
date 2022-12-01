package com.example.todolistsertificate.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistsertificate.R
import com.example.todolistsertificate.data.local.LocalStorage
import com.example.todolistsertificate.databinding.FragmentAddListBinding
import com.example.todolistsertificate.presenter.HomeViewModel
import com.example.todolistsertificate.ui.adapters.TaskAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_add_list) {
    private lateinit var binding: FragmentAddListBinding
    private val viewModel by viewModel<HomeViewModel>()
    private val adapter by lazy { TaskAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddListBinding.bind(view)
//        binding.rvList.adapter = adapter
        initRec()
        val recyclerView = binding.rvList
        initObservers()
        viewModel.getAllTodo(adapter, recyclerView)

//        adapter.setOnMenuItemCLickListener {
//            findNavController().navigate(HomeFragmentDirections.actionListFragmentToUpdateFragment())
//            Toast.makeText(requireContext(), "otti", Toast.LENGTH_SHORT).show()
//        }
    }

    private fun initRec() {
        binding.apply {
            rvList.adapter = adapter
            rvList.layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL,false)
            rvList.addItemDecoration(
                DividerItemDecoration(requireContext(),
                    DividerItemDecoration.VERTICAL)
            )
        }
    }

    private fun initObservers(){
        viewModel.successFlow.onEach {
            adapter.model = it.payload.toMutableList()
        }.launchIn(lifecycleScope)

        viewModel.loaderFlow.onEach {
            binding.progressBar.isVisible = it
        }.launchIn(lifecycleScope)

    }
}