package com.sim2g.icbt.ui.viewmodels

import androidx.databinding.Bindable
import androidx.lifecycle.viewModelScope
import com.sim2g.icbt.data.model.Operateur
import com.sim2g.icbt.data.repository.OperatorsRepository
import com.skydoves.bindables.BindingViewModel
import com.skydoves.bindables.asBindingProperty
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Farouk Sabiou on 2/19/22.
 */
@HiltViewModel
class OperatorsViewModel @Inject constructor(
    repository: OperatorsRepository) : BindingViewModel() {

    private val operatorsListFlow = repository.allOperators (
        onSuccess = {}
    )

    @get:Bindable
    val operatorsList: List<Operateur> by operatorsListFlow.asBindingProperty(viewModelScope, emptyList())
}