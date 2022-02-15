package com.sim2g.icbt.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.sim2g.icbt.R
import com.sim2g.icbt.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    companion object {
        const val LOGIN_SUCCESSFUL: String = "LOGIN_SUCCESSFUL"
    }

    private var _binding: FragmentLoginBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.loginBtn.setOnClickListener { loginUser() }
        return binding.root
    }

    fun loginUser() {
        val email = binding.loginField.text.toString()
        Log.println(Log.INFO, "mail", email)
        val password = binding.passwordField.text.toString()
        if (email.equals("konombo@hotmail.com") && password.equals("admin")) {
            Toast.makeText(context, "Login successfull", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.dashboardFragment)
        }
        else {
            binding.loginField.error = "User not found"
            binding.passwordField.error = "User not found"
        }
    }
}