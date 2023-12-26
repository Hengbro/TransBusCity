package com.transbuscity.core.source.remote.response.base

class BaseList <T>(
    val success: Int? =  null,
    val message: String? = null,
    val result: List<T> = emptyList()
)