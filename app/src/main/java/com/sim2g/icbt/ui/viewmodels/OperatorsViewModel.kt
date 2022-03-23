package com.sim2g.icbt.ui.viewmodels

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sim2g.icbt.data.model.Operateur
import com.sim2g.icbt.data.repository.OperatorsRepository
import com.skydoves.bindables.BindingViewModel
import com.skydoves.bindables.asBindingProperty
import com.skydoves.bindables.bindingProperty
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
    val operatorsList: List<Operateur> by operatorsListFlow
        .asBindingProperty(viewModelScope, emptyList())

    // Internally, we use a MutableLiveData to
    // handle navigation to the selected operator
    private val _navigateToSelectedOperator = MutableLiveData<Operateur>()

    // The external immutable LiveData for the navigation property
    val navigateToSelectedOperator: LiveData<Operateur>
        get() = _navigateToSelectedOperator

    // show selected operator details
    fun displayOperatorDetails(operateur: Operateur) {
        _navigateToSelectedOperator.value = operateur
    }

}