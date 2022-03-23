package com.sim2g.icbt.data.persistence

import androidx.room.*
import com.sim2g.icbt.data.model.Operateur

/**
 * Created by Farouk Sabiou on 2/19/22.
 */
@Dao
interface OperatorDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllOperators(operators: List<Operateur>)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertOperator(operator: Operateur): String

    @Update
    suspend fun updateOperator(operator: Operateur)

    @Query("SELECT * FROM operators WHERE id = :id")
    suspend fun getOperator(id: Long): Operateur

    @Query("SELECT * FROM operators")
    suspend fun getOperatorsList(): List<Operateur>

    // check if a given operator exist
    @Query("SELECT EXISTS(SELECT * FROM operators WHERE meloper = :email & password = :password)")
    suspend fun isOperatorValid(email: String, password: String): Boolean
}