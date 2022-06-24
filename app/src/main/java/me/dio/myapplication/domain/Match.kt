package me.dio.myapplication.domain

import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("descricao")
    val description : String,
    @SerializedName("Local")
    val place: Place,
    @SerializedName("Mandante")
    val HomeTeam: Team,
    @SerializedName("Visitante")
    val AwayTeam: Team

)
