package com.sim2g.icbt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.sim2g.icbt.databinding.FragmentLoginBinding

private lateinit var binding: FragmentLoginBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        val view = binding.root

        binding.loginBtn.setOnClickListener { loginUser() }
        setContentView(view)
    }

    fun loginUser() {
        val email = binding.loginField.text.toString()
        Log.println(Log.INFO, "mail", email)
        val password = binding.passwordField.text.toString()
        if (email.equals("konombo@hotmail.com") && password.equals("admin")) {
            Toast.makeText(applicationContext, "Login successfull", Toast.LENGTH_LONG).show()
        }
        else {
            binding.loginField.error = "User not found"
            binding.passwordField.error = "User not found"
        }
    }
}