package com.sim2g.icbt.ui.fragments.management

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.sim2g.icbt.data.model.Operateur
import com.sim2g.icbt.databinding.FragmentAddEditOperatorBinding
import com.sim2g.icbt.ui.viewmodels.AddEditOperatorViewModel

class AddEditOperatorFragment : Fragment() {

    private val viewModel: AddEditOperatorViewModel by viewModels()
    private var _binding: FragmentAddEditOperatorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddEditOperatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    enum class EditingState {
        EXISTING_OPERATOR,
        NEW_OPERATOR
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var operateur: Operateur? = null
        val args: AddEditOperatorFragmentArgs by navArgs()

//        val editingState = if (args.operatorId > 0) EditingState.EXISTING_OPERATOR
//        else EditingState.NEW_OPERATOR

//        if (editingState == EditingState.EXISTING_OPERATOR) {
//            viewModel.get(args.operatorId).observe(viewLifecycleOwner) { operatorItem ->
//                binding.txtRef.setText(operatorItem.idgroupe)
//                binding.txtNationalite.setText(operatorItem.nationalite)
//                binding.txtSex.setText(operatorItem.sexe)
//                binding.txtName.setText(operatorItem.nomoper)
//                binding.txtPassword.setText(operatorItem.password)
//                binding.txtFonction.setText(operatorItem.fonction)
//                binding.txtEmail.setText(operatorItem.meloper)
//                binding.txtPhone.setText(operatorItem.numero)
//                binding.datePicker.setText(operatorItem.datenaissance)
//                operateur = operatorItem
//            }
//        }

        // When the user clicks the Save button, use the data here to either update
        // an existing operator or create a new one
        binding.btnAddOperateur.setOnClickListener {
            //val context = requireContext().applicationContext
            //val navController = findNavController()

            viewModel.addOperator(
                operateur?.id.toString(),
                idgroupe = binding.txtGroup.text.toString(),
                nationalite = binding.txtNationalite.text.toString(),
                nomoper = binding.txtName.text.toString(),
                sexe = binding.txtSex.text.toString(),
                password = binding.txtPassword.text.toString(),
                fonction = binding.txtFonction.text.toString(),
                meloper = binding.txtEmail.text.toString(),
                numero = binding.txtPhone.text.toString(),
                datenaissance = binding.datePicker.text.toString(),
            )
        }
    }
}