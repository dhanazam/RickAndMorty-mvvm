package com.example.rickandmorty_mvvm.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.example.rickandmorty_mvvm.utils.Resource.Status.*

fun <T, A> performGetOperation(
    databaseQuery: () -> LiveData<T>,
    networkCall: suspend () -> Resource<A>,
    saveCallResult: suspend (A) -> Unit
): LiveData<Resource<T>> = liveData {

    emit(Resource.loading())
    val source = databaseQuery.invoke().map { Resource.success(it) }
    emitSource(source)

    val responseStatus = networkCall.invoke()
    if (responseStatus.status == SUCCESS) {
        saveCallResult(responseStatus.data!!)
    } else if (responseStatus.status == ERROR) {
        emit(Resource.error(responseStatus.message!!))
        emitSource(source)
    }
}