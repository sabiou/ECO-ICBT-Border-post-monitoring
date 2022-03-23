package com.sim2g.icbt.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sim2g.icbt.R
import com.sim2g.icbt.databinding.FragmentLoginBinding
import com.sim2g.icbt.firebase.auth.LoginViewModel
import com.sim2g.icbt.firebase.auth.LoginViewModel.AuthenticationState.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()

    private lateinit var auth: FirebaseAuth

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // If the user presses the back button, bring them back to the home screen
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().popBackStack(R.id.login, true)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        auth = Firebase.auth

        binding.viewModel = viewModel

        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authState ->
            when (authState) {
                AUTHENTICATED -> findNavController().apply {
                    popBackStack()
                    moveToMainScreen()
                }
                UNAUTHENTICATED -> findNavController().navigate(R.id.loginFragment)
                else -> INVALID_AUTHENTICATION
            }
        })

        binding.loginBtn.setOnClickListener {
            doUserLogin()
        }
        return binding.root
    }

    // do user login
    private fun doUserLogin() {
        try {
            val email = binding.loginField.text.toString().trim()
            val password = binding.passwordField.text.toString().trim()
            viewModel.loginUser(email, password)
        } catch (e: IllegalArgumentException) {
            Toast.makeText(
                context, "Field must not be empty.", Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun moveToMainScreen() {
        this.findNavController().navigate(R.id.dashboardFragment)
    }
}