package com.example.cartolafilmes.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIService {
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    const val API_KEY = "2af7a036f996b226bc467aa4f716139b"
    const val LANGUAGE = "pt-BR"
}