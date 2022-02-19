package com.sim2g.icbt.data.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.sim2g.icbt.data.model.Annee
import com.sim2g.icbt.network.Services
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import javax.inject.Inject

/**
 * Created by Farouk Sabiou on 2/17/22.
 */

class YearsOfEvaluationRepository @Inject constructor(private val services: Services) {

    @WorkerThread
    fun allActiveYears(
        onSuccess: () -> Unit,
    ) = flow {
        val years = services.getAllYears()
            // handles the success case when the API request gets a successful response.
            .suspendOnSuccess {
                emit(data)
            }
            /**
             * handles error cases when the API request gets an error response.
             * e.g., internal server error.
             * maps the [ApiResponse.Failure.Error] to the [PosterErrorResponse] using the mapper.
             */
            .onError {

            }
            // handles exceptional cases when the API request gets an exception response.
            // e.g., network connection error.
            .onException {
            }
    }.onCompletion { onSuccess() }.flowOn(Dispatchers.IO)

    @WorkerThread
    fun saveYear(
        year: Annee,
        onSuccess: () -> Unit,
    ) = flow {
        val addYear = services.addNewYear(year)
            // handles the success case when the API request gets a successful response.
            .suspendOnSuccess {
                emit(data)
            }
            /**
             * handles error cases when the API request gets an error response.
             * e.g., internal server error.
             * maps the [ApiResponse.Failure.Error] to the [PosterErrorResponse] using the mapper.
             */
            .onError {

            }
            // handles exceptional cases when the API request gets an exception response.
            // e.g., network connection error.
            .onException {
            }
    }.onCompletion { onSuccess() }.flowOn(Dispatchers.IO)
}