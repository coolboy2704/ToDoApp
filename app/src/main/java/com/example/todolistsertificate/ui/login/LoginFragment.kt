package com.example.todolistsertificate.ui.login


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.todolistsertificate.R
import com.example.todolistsertificate.databinding.FragmentLoginBinding
import com.example.todolistsertificate.presenter.LoginViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var navController: NavController
    private val viewModel by viewModel<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        navController = findNavController()
        initObservers()

        binding.apply {

            binding.bnRegister.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
            }

            bnLogin.setOnClickListener {
                val number = etNumber.text.toString()
                val password = etPassword.text.toString()

                viewModel.login(number, password)
            }

        }

    }

    private fun initObservers() {
        viewModel.loginSuccessFlow.onEach {
            if (it == 200) {
                navController.navigate(R.id.action_loginFragment_to_listFragment)
                Toast.makeText(requireContext(), "CORRECT", Toast.LENGTH_SHORT).show()
            }
        }.launchIn(lifecycleScope)

        viewModel.errorFlow.onEach {
            Toast.makeText(requireContext(), "Error keldi", Toast.LENGTH_SHORT).show()
        }.launchIn(lifecycleScope)


        viewModel.messageFlow.onEach {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }.launchIn(lifecycleScope)

        viewModel.loaderFlow.onEach {
            binding.progressBar.isVisible = it
        }.launchIn(lifecycleScope)
    }
}