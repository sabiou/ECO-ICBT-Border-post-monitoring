package com.sim2g.icbt.ui.viewmodels

import androidx.databinding.Bindable
import androidx.lifecycle.viewModelScope
import com.sim2g.icbt.data.model.IOV
import com.sim2g.icbt.data.repository.IovRepository
import com.skydoves.bindables.BindingViewModel
import com.skydoves.bindables.asBindingProperty
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Farouk Sabiou on 3/21/22.
 */
@HiltViewModel
class IovViewModel @Inject constructor(
    iovRepository: IovRepository): BindingViewModel() {

    private val iovListFlow = iovRepository.allIov (
        onSuccess = {}
    )

    @get:Bindable
    val iovList: List<IOV> by iovListFlow
        .asBindingProperty(viewModelScope, emptyList())

}