package com.sim2g.icbt.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sim2g.icbt.data.model.Evaliovan
import com.sim2g.icbt.data.model.Operateur
import com.sim2g.icbt.data.repository.EvaliovanRepository
import com.sim2g.icbt.network.Services
import com.skydoves.bindables.asBindingProperty
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Farouk Sabiou on 2/15/22.
 */
@HiltViewModel
class DashboardViewModel @Inject constructor
    (private val services: Services) : ViewModel() {}