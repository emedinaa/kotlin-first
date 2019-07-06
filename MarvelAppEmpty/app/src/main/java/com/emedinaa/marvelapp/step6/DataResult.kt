package com.emedinaa.marvelapp.step6

sealed class DataResult<out T>{

    data class Success<T>(val data:List<T>):DataResult<List<T>>()
    data class Failure(val e:Exception): DataResult<Nothing>()
}