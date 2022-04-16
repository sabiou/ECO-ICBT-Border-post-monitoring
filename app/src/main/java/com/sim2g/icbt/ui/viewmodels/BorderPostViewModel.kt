package com.sim2g.icbt.ui.viewmodels

import android.annotation.SuppressLint
import androidx.annotation.WorkerThread
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sim2g.icbt.data.model.BorderPost
import com.sim2g.icbt.data.repository.BorderPostRepository
import com.sim2g.icbt.network.Services
import com.skydoves.bindables.BindingViewModel
import com.skydoves.bindables.asBindingProperty
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Farouk Sabiou on 3/21/22.
 */
@HiltViewModel
class BorderPostViewModel @Inject constructor(
    private val borderPostRepository: BorderPostRepository,
    private val services: Services
) : BindingViewModel() {

    init {
        getBorderPostByCountry("burkina")
    }

    // The internal MutableLiveData String that stores the most recent response
    private val _bordersPosts = MutableLiveData<List<BorderPost>>()

    val bordersPosts: LiveData<List<BorderPost>>
        get() = _bordersPosts

    private val borderPostsFlow = borderPostRepository.allBorder(
        onSuccess = {}
    )

    private val countriesBorderPostsFlow = borderPostRepository.borderPostsByCountry(
        country = "burkina",
        onSuccess = {}
    )

//    @get:Bindable
//    val borderPosts: List<BorderPost> by borderPostsFlow
//        .asBindingProperty(viewModelScope, emptyList())

//    @get:Bindable
//    val borderPostsByCountry: List<BorderPost> by countriesBorderPostsFlow
//        .asBindingProperty(viewModelScope, emptyList())

    @SuppressLint("NullSafeMutableLiveData")
    fun getBorderPostByCountry(
        country: String
    ) {
        viewModelScope.launch {
            services.borderPostByCountry(country).enqueue(object : Callback<List<BorderPost>> {
                override fun onResponse(
                    call: Call<List<BorderPost>>,
                    response: Response<List<BorderPost>>
                ) {
                    _bordersPosts.value = response.body()
                }

                override fun onFailure(call: Call<List<BorderPost>>, t: Throwable) {
                    Timber.e(t.message)
                }

            })
        }
    }

}