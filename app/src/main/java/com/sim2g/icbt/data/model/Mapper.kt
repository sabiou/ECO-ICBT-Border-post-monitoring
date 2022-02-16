package com.sim2g.icbt.data.model

/**
 * Created by Farouk Sabiou on 2/16/22.
 */
interface Mapper<F, T> {
    suspend fun map(from: F): T
}

interface IndexedMapper<F, T> {
    suspend fun map(index: Int, from: F): T
}