package com.android.catchtable.data.util

import com.android.catchtable.data.remote.dto.base.ErrorResponse
import com.android.catchtable.domain.exception.ApiException
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.json.Json
import retrofit2.HttpException
import kotlin.coroutines.cancellation.CancellationException

suspend fun <R> suspendRunCatching(block: suspend () -> R): Result<R> {
    return try {
        Result.success(block())
    } catch (t: TimeoutCancellationException) {
        Result.failure(t)
    } catch (c: CancellationException) {
        throw c
    } catch (e: HttpException) {
        Result.failure(e.toApiException())
    } catch (e: Throwable) {
        currentCoroutineContext().ensureActive()
        Result.failure(e)
    }
}

private fun HttpException.toApiException(): Throwable {
    val error = response()?.errorBody()?.string()?.let {
        runCatching { catchTableJson.decodeFromString<ErrorResponse>(it) }.getOrNull()
    } ?: return this
    return ApiException(httpCode = code(), code = error.code, message = error.message)
}
