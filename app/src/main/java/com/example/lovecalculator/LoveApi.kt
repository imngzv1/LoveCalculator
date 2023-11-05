package com.example.lovecalculator

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun getPercentage(
        @Query("fname")firstName:String,
        @Query("sname")secondName:String,
        @Header("X-RapidAPI-Key") key:String="41ed98c626msh68c4cff64a2d086p1ffe7bjsn9196f931643d",
        @Header("X-RapidAPI-Host") host:String="love-calculator.p.rapidapi.com"
    ):Call<LoveModel>
}