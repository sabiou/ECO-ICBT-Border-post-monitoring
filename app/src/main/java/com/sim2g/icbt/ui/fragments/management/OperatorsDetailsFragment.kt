package com.sim2g.icbt.ui.fragments.management

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sim2g.icbt.R
import com.sim2g.icbt.databinding.FragmentOperatorsDetailsBinding
import com.sim2g.icbt.ui.viewmodels.OperatorsDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OperatorsDetailsFragment : Fragment() {

    private val viewModel: OperatorsDetailsViewModel by lazy {
        ViewModelProvider(this)[OperatorsDetailsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentOperatorsDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner

        val operateur = OperatorsDetailsFragmentArgs.fromBundle(requireArguments()).operator
        binding.viewModel = viewModel
        binding.operateur = operateur
        // (getString(R.string.text_nationalite) + operateur.nationalite).also { binding.textOpCitizenship.text = it }
        "Citizenship: ${operateur.nationalite}".also { binding.textOpCitizenship.text = it }
        "Function: ${operateur.fonction}".also { binding.textOpFunction.text = it }
        "Sexe: ${operateur.sexe}".also { binding.txtOpSex.text = it }
        "Email: ${operateur.meloper}".also { binding.txtOpEmail.text = it }

        binding.btnEditOp.setOnClickListener {
            findNavController().navigate(OperatorsDetailsFragmentDirections
                .actionOperatorsDetailsFragmentToAddEditOperatorFragment(operateur.id))
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().popBackStack()
        }
    }
}