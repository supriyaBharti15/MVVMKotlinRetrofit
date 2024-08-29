package com.example.mvvmtest3.repository

import com.example.mvvmtest3.network.MyApi
import com.example.mvvmtest3.network.SafeApiCall

class AlbumRepository(private val myApi: MyApi) : SafeApiCall() {
    suspend fun getAlbum() = apiRequest { myApi.getAlbum() }

}