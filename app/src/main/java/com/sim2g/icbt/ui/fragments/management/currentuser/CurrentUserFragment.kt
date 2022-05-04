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
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class CurrentUserFragment : Fragment() {

    private var _binding: FragmentCurrentUserBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrentUserBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        // get current user
        val currentUser = FirebaseAuth.getInstance().currentUser
        currentUser?.let {
            val name = it.displayName
            // binding.userName.text = name
            val email = it.email
            binding.userEmail.text = email
        }
        currentUser?.reload()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun moveToLogin() {
        this.findNavController().navigate(CurrentUserFragmentDirections.actionCurrentUserFragmentToLogin())
        this.findNavController().popBackStack()
    }
}