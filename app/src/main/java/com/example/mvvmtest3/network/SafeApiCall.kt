package com.example.mvvmtest3.network

import okio.IOException
import retrofit2.Response

/*
this function will perform api request
 */
abstract class SafeApiCall {
    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw ApiException(response.code().toString())
        }
    }
}

/*
Class to handle API Exception
 */
class ApiException(message: String) : IOException(message)