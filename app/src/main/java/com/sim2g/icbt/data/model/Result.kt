package com.sim2g.icbt.data.model

/**
 * Created by Farouk Sabiou on 2/16/22.
 */
sealed class Result<T> {
    open fun get(): T? = null

    fun getOrThrow(): T = when (this) {
        is Success -> get()
        is ErrorResult -> throw throwable
    }
}

data class Success<T>(val data: T, val responseModified: Boolean = true) :Result<T>() {
    override fun get(): T = data
}

data class ErrorResult<T>(val throwable: Throwable): Result<T>()