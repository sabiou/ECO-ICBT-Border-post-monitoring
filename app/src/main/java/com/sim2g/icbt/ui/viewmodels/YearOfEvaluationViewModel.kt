package com.sim2g.icbt.ui.viewmodels

import androidx.databinding.Bindable
import androidx.lifecycle.viewModelScope
import com.sim2g.icbt.data.model.Annee
import com.sim2g.icbt.data.repository.YearsOfEvaluationRepository
import com.skydoves.bindables.BindingViewModel
import com.skydoves.bindables.asBindingProperty
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Farouk Sabiou on 2/16/22.
 */
@HiltViewModel
class YearOfEvaluationViewModel @Inject constructor
    (repository: YearsOfEvaluationRepository) : BindingViewModel() {

    private val yearsListFlow = repository.allActiveYears(
        onSuccess = {}
    )

    @get:Bindable
    val yearsList: List<Annee> by yearsListFlow.asBindingProperty(viewModelScope, emptyList())
}