package me.dio.myapplication.domain

import com.google.gson.annotations.SerializedName

data class Team(

     @SerializedName("nome")
    val name: String,
     @SerializedName("imagem")
     val image: String ,
     @SerializedName("forca")
            val stars: Int
 )
