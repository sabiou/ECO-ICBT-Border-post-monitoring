package com.sim2g.icbt.ui.viewmodels

import com.sim2g.icbt.data.repository.YearsOfEvaluationRepository
import com.skydoves.bindables.BindingViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Farouk Sabiou on 2/19/22.
 */
@HiltViewModel
class AddYearOfEvaluationViewModel @Inject constructor
    (repository: YearsOfEvaluationRepository) : BindingViewModel() {
}