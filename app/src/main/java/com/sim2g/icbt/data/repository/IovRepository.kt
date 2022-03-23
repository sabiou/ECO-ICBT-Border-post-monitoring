package com.sim2g.icbt.data.repository

import androidx.annotation.WorkerThread
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
 * Created by Farouk Sabiou on 3/21/22.
 */
class IovRepository @Inject constructor(
    private val services: Services,
    private val iovDAO: IovDAO
) {
    @WorkerThread
    fun allIov(
        onSuccess: () -> Unit,
    ) = flow {
        val iov = iovDAO.getAllIovList()
        if (iov.isEmpty()) {
            // request API network request asynchronously.
            services.findAllEvaluation()
                // handles the success in case when the API request gets a successful response.
                .suspendOnSuccess {
                    // insert operators in database for cache purpose
                    iovDAO.insertAllIov(data)
                    emit(data)
                    //Timber.v("here is the data: $data")
                }
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
            emit(iov)
        }
    }.onCompletion { onSuccess() }.flowOn(Dispatchers.IO)

}