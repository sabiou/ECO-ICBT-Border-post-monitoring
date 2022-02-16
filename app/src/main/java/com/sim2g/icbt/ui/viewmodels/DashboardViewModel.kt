package com.sim2g.icbt.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sim2g.icbt.data.model.Annee
import com.sim2g.icbt.network.Network
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Farouk Sabiou on 2/15/22.
 */
class DashboardViewModel: ViewModel() {

    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response

    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        //getEvaluationYears()
        //findYearById()
    }

    /**
     * Sets the value of the response LiveData to the API status or the successful number of
     * years retrieved.
     */
    private fun getEvaluationYears() {
        Network.api.getAllYears().enqueue(object : Callback<List<Annee>> {
            override fun onResponse(call: Call<List<Annee>>, response: Response<List<Annee>>) {
                _response.value = " Success: ${response.body()?.size} evaluation years retrieved"
            }

            override fun onFailure(call: Call<List<Annee>>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }
        })
    }

    private fun findYearById() {
        Network.api.findYearById("2017").enqueue(object : Callback<Annee> {
            override fun onResponse(call: Call<Annee>, response: Response<Annee>) {
                _response.value = " Success: ${response.body()} evaluation years retrieved"
            }

            override fun onFailure(call: Call<Annee>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }

        })
    }
}