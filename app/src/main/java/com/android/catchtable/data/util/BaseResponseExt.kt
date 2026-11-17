package com.android.catchtable.data.util

import com.android.catchtable.data.remote.dto.base.BaseResponse

fun <T> BaseResponse<T>.getDataOrThrow(): T =
    data ?: throw IllegalStateException(message)
