package com.transbuscity.core.source.remote.response.base

class BaseSingle <T>(
    val success: Int? =  null,
    val message:String? = null,
    val results: T?= null
)