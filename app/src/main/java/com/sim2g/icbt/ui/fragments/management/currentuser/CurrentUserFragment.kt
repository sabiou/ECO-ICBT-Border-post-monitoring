package com.sim2g.icbt.ui.fragments.management.currentuser

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.sim2g.icbt.R
import com.sim2g.icbt.databinding.FragmentCurrentUserBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CurrentUserFragment : Fragment() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCurrentUserBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.btnLogOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            sharedPreferences.edit().putBoolean("loggedin", false).apply()
            moveToLogin()
        }

        return binding.root
    }

    private fun moveToLogin() {
        this.findNavController().navigate(CurrentUserFragmentDirections.actionCurrentUserFragmentToLogin())
    }
}