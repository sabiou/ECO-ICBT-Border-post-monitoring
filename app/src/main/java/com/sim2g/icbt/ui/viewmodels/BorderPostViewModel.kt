package com.sim2g.icbt.ui.viewmodels

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sim2g.icbt.data.model.BorderPost
import com.sim2g.icbt.data.model.Operateur
import com.sim2g.icbt.data.repository.BorderPostRepository
import com.sim2g.icbt.network.Services
import com.skydoves.bindables.BindingViewModel
import com.skydoves.bindables.asBindingProperty
import dagger.hilt.android.lifecycle.HiltViewModel
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
    borderPostRepository: BorderPostRepository,
    private val services: Services): BindingViewModel() {

    // The internal MutableLiveData String that stores the most recent response
    private val _borderspost = MutableLiveData<List<BorderPost>>()

    private val borderPostsFlow = borderPostRepository.allBorder (
        onSuccess = {}
    )

    @get:Bindable
    val borderPosts: List<BorderPost> by borderPostsFlow
        .asBindingProperty(viewModelScope, emptyList())

    fun getBorderPostByCountry(country: String) {
        viewModelScope.launch {
            val postsResult = services.getBorderPostByCountry(country)
            if (postsResult.isNotEmpty()) {
                _borderspost.value = postsResult
            }
        }
    }

}