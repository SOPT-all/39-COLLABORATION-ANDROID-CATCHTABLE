package com.android.catchtable.domain.exception

class ApiException(
    val httpCode: Int,
    val code: String,
    override val message: String,
) : Exception(message)
