package com.sim2g.icbt.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sim2g.icbt.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Farouk Sabiou on 2/16/22.
 */
@HiltViewModel
class YearOfEvaluationViewModel @Inject constructor(
    repository: Repository
) : ViewModel() {
    val yearsOfEvaluation = repository.getYearsOfEvaluation().asLiveData()
}