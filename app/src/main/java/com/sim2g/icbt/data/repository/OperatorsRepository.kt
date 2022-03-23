package com.sim2g.icbt.data.repository

import androidx.annotation.WorkerThread
import com.sim2g.icbt.data.persistence.OperatorDAO
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
 * Created by Farouk Sabiou on 2/19/22.
 */
class OperatorsRepository @Inject constructor(
    private val services: Services,
    private val operatorDAO: OperatorDAO
) {
    @WorkerThread
    fun allOperators(
        onSuccess: () -> Unit,
    ) = flow {
        val operators = operatorDAO.getOperatorsList()
        if (operators.isEmpty()) {
            // request API network request asynchronously.
            services.findAllOperateur()
                // handles the success in case when the API request gets a successful response.
                .suspendOnSuccess {
                    // insert operators in database for cache purpose
                    operatorDAO.insertAllOperators(data)
                    emit(data)
                    //Timber.v("here is the data: $data")
                }
                .onError {
                    // to handle later
                }
                .onException {}
        } else {
            emit(operators)
        }
    }.onCompletion { onSuccess() }.flowOn(Dispatchers.IO)
}