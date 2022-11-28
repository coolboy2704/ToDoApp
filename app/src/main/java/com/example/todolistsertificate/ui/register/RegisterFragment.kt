package com.example.todolistsertificate.ui.register

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.todolistsertificate.R
import com.example.todolistsertificate.databinding.FragmentRegisterBinding
import com.example.todolistsertificate.presenter.RegisterViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : Fragment(R.layout.fragment_register) {
    private lateinit var binding: FragmentRegisterBinding
    private val viewModel by viewModel<RegisterViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)
        initObservers()


        binding.apply {

            btRegister.setOnClickListener {
                val phone = etPhone.text.toString()
                val name = etName.text.toString()
                val password = etPassword.text.toString()

                viewModel.register(phone, name, password)

            }
        }
    }

    private fun initObservers(){
        viewModel.registerSuccessFlow.onEach {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }.launchIn(lifecycleScope)
    }

    private fun setLoading(loading: Boolean){
        binding.progressBar.isVisible = loading
    }

}