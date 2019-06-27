package com.sample

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



class ClientNetwork {
    var BASE_URL = "http://api.duckduckgo.com"
    lateinit var retrofit: Retrofit
    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    fun getClientNetworkModule():Retrofit{

        return retrofit
    }


}
