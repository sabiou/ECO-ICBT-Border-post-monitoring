package com.sim2g.icbt.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sim2g.icbt.data.model.Annee
import com.sim2g.icbt.network.Network
import kotlinx.coroutines.launch

/**
 * Created by Farouk Sabiou on 2/16/22.
 */
class YearOfEvaluationViewModel: ViewModel() {

    // The internal MutableLiveData String that stores the most recent response status
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the status String
    val status: LiveData<String>
        get() = _status

    private val _years = MutableLiveData<List<Annee>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val years: LiveData<List<Annee>>
        get() = _years

    /**
     * Call getEvaluationsYears() on init so we can display status immediately.
     */
    init {
        getEvaluationsYears()
    }

    private fun getEvaluationsYears() {
        viewModelScope.launch {
            try {
                val result = Network.api.getAllYears()
                _years.value = result
            } catch (e: Exception) {
                _status.value = "Faillure: ${e.message}"
            }
        }
    }
}