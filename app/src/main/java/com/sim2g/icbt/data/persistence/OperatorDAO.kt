package com.sim2g.icbt.data.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sim2g.icbt.data.model.Operateur

/**
 * Created by Farouk Sabiou on 2/19/22.
 */
@Dao
interface OperatorDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addOperatorList(operators: List<Operateur>)

    @Query("SELECT * FROM operators WHERE id = :id")
    suspend fun getOperator(id: String): Operateur

    @Query("SELECT * FROM operators")
    suspend fun getOperatorsList(): List<Operateur>

    // check if a given operator exist
    @Query("SELECT EXISTS(SELECT * FROM operators WHERE meloper = :email & password = :password)")
    fun isOperatorValid(email: String, password: String): Boolean
}