package com.sim2g.icbt.mappers

import com.sim2g.icbt.data.model.Annee
import com.sim2g.icbt.data.model.Mapper
import com.sim2g.icbt.network.YearOfEvalResponse
import javax.inject.Inject

/**
 * Created by Farouk Sabiou on 2/16/22.
 */
class YearsOfEvalResponseToYearsOfEval @Inject constructor():
        Mapper<YearOfEvalResponse, Annee> {
    override suspend fun map(from: YearOfEvalResponse): Annee {
        return from.results.map { result ->
            Annee (
                id = result.id,
                datedebut = result.dateDebut,
                datefin = result.dateFin,
                status = result.status,
                annee = result.annee
            )
        }.first()
    }

}