package com.sim2g.icbt.data.repository

import androidx.annotation.WorkerThread
import com.sim2g.icbt.data.persistence.EvaliovanDAO
import com.sim2g.icbt.network.Services
import com.skydoves.sandwich.ApiResponse
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
 * Created by Farouk Sabiou on 3/17/22.
 */
class EvaliovanRepository @Inject constructor(private val services: Services,
                                              private val evaliovanDAO: EvaliovanDAO
) {
    @WorkerThread
    fun allEvaliovan(
        onSuccess: () -> Unit,
    ) = flow {
        val evaliovan = evaliovanDAO.getEvaliovanList()
        if (evaliovan.isEmpty()) {
            // request API network request asynchronously.
            services.findAllEvaliovan()
                // handles the success in case when the API request gets a successful response.
                .suspendOnSuccess {
                    // insert operators in database for cache purpose
                    evaliovanDAO.insertAllEvaliovanList(data)
                    emit(data)
                    // Timber.v("here is the data: $data")
                }
                .onError {
                    // to handle later
                }
                // handles exceptional cases when the API request gets an exception response.
                // e.g., network connection error.
                .onException {}
        } else {
            emit(evaliovan)
        }
    }.onCompletion { onSuccess() }.flowOn(Dispatchers.IO)
}