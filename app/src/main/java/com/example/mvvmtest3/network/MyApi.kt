package com.example.mvvmtest3.network

import com.example.mvvmtest3.model.AlbumResponseItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi {
    /*
    all network call fun should be suspend:: part of coroutine
     */
    @GET("/albums")
     suspend fun getAlbum(): Response<List<AlbumResponseItem>>

    companion object{
        operator fun invoke(): MyApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()
                .create(MyApi::class.java)

        }
    }
}