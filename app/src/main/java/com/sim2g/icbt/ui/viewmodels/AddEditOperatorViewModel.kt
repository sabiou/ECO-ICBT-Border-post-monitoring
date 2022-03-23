package com.sim2g.icbt.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.sim2g.icbt.data.model.Operateur
import com.sim2g.icbt.data.persistence.OperatorDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Farouk Sabiou on 2/27/22.
 */
class AddEditOperatorViewModel @Inject constructor( private val operatorDAO: OperatorDAO) : ViewModel() {

    private var operatorLiveData: LiveData<Operateur>? = null

    fun get(id: Long): LiveData<Operateur> {
        return operatorLiveData ?: liveData {
            emit(operatorDAO.getOperator(id))
        }.also {
            operatorLiveData = it
        }
    }

    fun addOperator(
        id: String,
        idgroupe: String,
        nationalite: String,
        sexe: String,
        nomoper: String,
        password: String,
        fonction: String,
        meloper: String,
        numero: String,
        datenaissance: String
    ) {
//        val operateur = Operateur(
//            id.toString(),
//            idgroupe,
//            nationalite,
//            sexe,
//            nomoper,
//            password,
//            fonction,
//            meloper,
//            numero,
//            datenaissance,
//            "",
//            "",
//            "",
//            "",
//            "",
//            "",
//            ""
//        )
//
//        viewModelScope.launch {
//            var actualId = id
//            if (id > 0) {
//                updateOperator(operateur)
//            } else {
//                insertNewOperator(operateur)
//            }
//        }
    }

//    private suspend fun insertNewOperator(operateur: Operateur): Long {
//        return operatorDAO.insertOperator(operateur)
//    }

    private fun updateOperator(operateur: Operateur) = viewModelScope.launch(Dispatchers.IO) {
        operatorDAO.updateOperator(operateur)
    }
}