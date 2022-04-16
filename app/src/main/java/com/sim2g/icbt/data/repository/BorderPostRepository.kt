package com.sim2g.icbt.data.repository

import androidx.annotation.WorkerThread
import com.sim2g.icbt.data.persistence.BorderPostDAO
import com.sim2g.icbt.data.persistence.IovDAO
import com.sim2g.icbt.network.Services
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Farouk Sabiou on 3/22/22.
 */
class BorderPostRepository @Inject constructor(
    private val services: Services,
    private val borderPostDAO: BorderPostDAO
) {
    @WorkerThread
    fun allBorder(
        onSuccess: () -> Unit,
    ) = flow {
        val borders = borderPostDAO.getAllBorderPosts()
        if (borders.isEmpty()) {
            // request API network request asynchronously.
            services.getBorderPosts()
                // handles the success in case when the API request gets a successful response.
                .suspendOnSuccess {
                    // insert operators in database for cache purpose
                    borderPostDAO.insertAllBordersPosts(data)
                    emit(data)
                    Timber.v("here is the data: $data")
                }
                /**
                 * handles error cases when the API request gets an error response.
                 * e.g., internal server error.
                 */
                /**
                 * handles error cases when the API request gets an error response.
                 * e.g., internal server error.
                 */
                /**
                 * handles error cases when the API request gets an error response.
                 * e.g., internal server error.
                 */
                /**
                 * handles error cases when the API request gets an error response.
                 * e.g., internal server error.
                 */
                .onError {
                    // to handle later
                }
                // handles exceptional cases when the API request gets an exception response.
                // e.g., network connection error.
                .onException {}
        } else {
            emit(borders)
        }
    }.onCompletion { onSuccess() }.flowOn(Dispatchers.IO)

    fun borderPostsByCountry(
        country: String,
        onSuccess: () -> Unit,
    ) = flow {
        val borders = borderPostDAO.getAllBorderPosts()
        if (borders.isEmpty()) {
            // request API network request asynchronously.
            services.getBorderPostByCountry(country)
                // handles the success in case when the API request gets a successful response.
                .suspendOnSuccess {
                    // insert operators in database for cache purpose
                    borderPostDAO.insertAllBordersPosts(data)
                    emit(data)
                    Timber.v("here is the data: $data")
                }
                /**
                 * handles error cases when the API request gets an error response.
                 * e.g., internal server error.
                 */
                /**
                 * handles error cases when the API request gets an error response.
                 * e.g., internal server error.
                 */
                /**
                 * handles error cases when the API request gets an error response.
                 * e.g., internal server error.
                 */
                /**
                 * handles error cases when the API request gets an error response.
                 * e.g., internal server error.
                 */
                .onError {
                    // to handle later
                }
                // handles exceptional cases when the API request gets an exception response.
                // e.g., network connection error.
                .onException {}
        } else {
            emit(borders)
        }
    }.onCompletion { onSuccess() }.flowOn(Dispatchers.IO)

}