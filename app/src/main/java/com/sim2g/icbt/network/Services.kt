package com.sim2g.icbt.network

import com.google.gson.GsonBuilder
import com.sim2g.icbt.data.model.*
import com.skydoves.sandwich.ApiResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

/**
 * Created by Farouk Sabiou on 2/15/22.
 *
 * This file contains all endpoints query
 */

private const val BASE_URL = "http://monitoringtls-bakend.net/sim2g/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

interface Services {
    /**
     * CRUD operations on evaluations years
     */
    // get a list of all years of evaluation
    @GET("annee/all")
    suspend fun getAllYears(): ApiResponse<List<Annee>>
    // get a list of all years of evaluation (active only)
    @GET("annee/actif")
    suspend fun findAllActiveYears(): List<Annee>
    // get a list of all years of evaluation (inactive only)
    @GET("annee/inactif")
    fun findAllInactiveYears(): List<Annee>
    // get a specific years of evaluation by it's id
    @GET("annee/byid/{id}")
    fun findYearById(@Path("id") id: String): Call<Annee>
    // add a new year of evaluation
    @POST("annee/create")
    fun addNewYear(@Body annee: Annee): ApiResponse<Call<Annee>>
    // delete a given year of evaluation record
    @DELETE("annee/delete/{id}")
    fun deleteYear(@Query("id") id: String)

   /**
    * CRUD operations on IOV
    */
    @GET("iov/actif")
    fun findAllActiveEvaluation(): Call<List<IOV>>

    @GET("iov/all")
    fun findAllEvaluation(): Call<List<IOV>>

    @GET("iov/inactif")
    fun findAllInactiveEvaluation(): Call<List<IOV>>

    @GET("iov/all")
    fun findAll(): Call<List<IOV>>

    @GET("iov/byid/{id}")
    fun getEvaluationById(@Path("id") id: String): Call<IOV>

    @DELETE("iov/delete/{id}")
    fun deleteEvaluation(@Query("id") id: String)

    @POST("iov/create")
    fun addEvaluation(@Body iov: IOV): Call<IOV>

    /**
     * CRUD operations on Operateur
     */
    @GET("operateur/email/{meloper}")
    fun findOperateurByMeloper(@Path("meloper") meloper: String): Call<Operateur>

    @GET("operateur/all")
    fun findAllOperateur(): Call<List<Operateur>>

    @GET("operateur/edite")
    fun editOperateur(@Path("id") id: String): Call<Operateur>

    @GET("operateur/groupeAdmin")
    fun listOperateurAdmin(): Call<List<Operateur>>

    @GET("operateur/groupeColl")
    fun listOperateurColl(): Call<List<Operateur>>

    @GET("operateur/groupeExp")
    fun listOperateurExp(): Call<List<Operateur>>

    @GET("operateur/groupePfco")
    fun listOperateurPfco(): Call<List<Operateur>>

    @GET("operateur/groupePmo")
    fun listOperateurPro(): Call<List<Operateur>>

    @GET("operateur/groupeSut")
    fun listOperateurSut(): Call<List<Operateur>>

    @GET("operateur/idgroupe/{idgroupe}")
    fun findOperateurByIdGroup(@Path("idgroupe") idgroup: String): Call<List<Operateur>>

    @GET("operateur/nationalite/{nationalite}")
    fun listOperateurParPays(@Path("nationalite") nationalite: String): Call<List<Operateur>>

    @GET("operateur/nationalite/{nationalite}/{idgroupe}")
    fun listOperateurParPaysEtGroupe(
        @Path("idgroupe") idgroup: String,
        @Path("nationalite") nationalite: String): Call<List<Operateur>>

    // bug:// request was "iov/delete/{id} instead of operateur/delete/{id}
    @DELETE("operateur/delete/{id}")
    fun deleteOperateur(@Query("id") id: String)

    @POST("operateur/create")
    fun addOperateur(@Body operateur: Operateur): Call<Operateur>

    /**
     * CRUD operations on Group
     */
    @GET("groupe/all")
    fun findAllGroup(): Call<List<Groupe>>

    @GET("groupe/id/{id}")
    fun findgroupById(@Path("id") id: String): Call<List<Groupe>>

    @GET("groupe/edite/{id}")
    fun editGroup(@Path("id") id: String): Call<Groupe>

    @POST("groupe/create")
    fun addNewGroup(@Body groupe: Groupe): Call<Groupe>

    @DELETE("group/delete/{id}")
    fun deleteGroup(@Query("id") id: String)

    /**
     * CRUD operations on UserPoste
     */
    @GET("user_post/actif")
    fun findAllActiveUserPost(): Call<List<UserPoste>>

    @GET("user_post/inactif")
    fun findAllInactiveUserPost(): Call<List<UserPoste>>

    @GET("user_post/all")
    fun findAllUserPost(): Call<List<UserPoste>>

    @GET("user_post/byid/{id}")
    fun findUserPostById(@Path("id") id: String): Call<List<UserPoste>>

    @GET("user_post/codeopper/{codeopper}")
    fun listPostParCodeOperateur(): Call<List<UserPoste>>

    @GET("user_post/create")
    fun addUserPost(@Body userPoste: UserPoste): Call<UserPoste>

    @DELETE("user_post/delete/{id}")
    fun deleteUserPost(@Query("id") id: String)

    @GET("user_post/edite/{id}")
    fun editUserPost(@Path("id") id: String): Call<UserPoste>

    /**
     * CRUD operations on Evaliovan
     */
    @GET("evaliovan/actif")
    fun findAllActiveEvaliovan(): Call<List<Evaliovan>>

    @GET("evaliovan/all")
    fun findAllEvaliovan(): Call<List<Evaliovan>>

    @GET("evaliovan/inactif")
    fun findAllInactiveEvaliovan(): Call<List<Evaliovan>>

    @GET("evaliovan/byid/{id}")
    fun getEvaliovanById(@Path("id") id: String): Call<Evaliovan>

    @GET("evaliovan/annee/{annee}")
    fun listEvaliovanParAnnee(@Path("annee") annee: Int): Call<List<Evaliovan>>

    @GET("evaliovan/annee_poste/{annee}/{id}")
    fun listEvaliovanParPosteEtAnnee(
        @Path("annee") annnee: Int,
        @Path("idposte") idposte: String): Call<List<Evaliovan>>

    @GET("evaliovan/idiov/{idiov}/idposte/{idposte}")
    fun listEvaliovanParPosteEtIdiovs(
        @Path("idiov") idiov: String,
        @Path("idposte") idposte: String): Call<List<Evaliovan>>

    @DELETE("evaliovan/delete/{id}")
    fun deleteEvaliovan(@Query("id") id: String)

    @POST("evaliovan/create")
    fun addEvaliovan(@Body evaliovan: Evaliovan): Call<Evaliovan>

    @GET("evaliovan/edite/{id}")
    fun editEvaliovan(@Path("id") id: String)

}

//object Network {
//    // Configure retrofit to parse JSON
//    private val retrofit = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(MoshiConverterFactory.create(moshi))
//        .build()
//
//    val api: Services = retrofit.create(Services::class.java)
//}