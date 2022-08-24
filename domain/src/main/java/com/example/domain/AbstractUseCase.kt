package com.example.domain

import com.example.cache.Cache
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.UnknownHostException

abstract class AbstractUseCase<in PARAMETER, out RESULT> constructor(
    private val cache: Cache<RESULT>? = null,
    private val key: String? = null,
) {

    protected abstract suspend fun execute(param: PARAMETER): RESULT

    private var lastedPARAMETER: PARAMETER? = null

    // I put this suppresses because it is error handle layer, then we need catch any error here
    @Suppress("TooGenericExceptionCaught")
    open operator fun invoke(
        value: PARAMETER,
        forceLoad: Boolean? = false,
    ): Flow<ResultWrapper<RESULT>> = flow {
        emit(ResultWrapper.Loading)
        try {
            val result = withContext(IO) {
                cache?.get(key, (forceLoad ?: false) || (lastedPARAMETER != null && value != lastedPARAMETER)) {
                    execute(value)
                } ?: execute(value)
            }
            lastedPARAMETER = value
            emit(ResultWrapper.Success(result))
        } catch (e: UnknownHostException) {
            emit(ResultWrapper.Error(ErrorWrapper.NetworkException(cause = e)))
        } catch (e: HttpException) {
            emit(
                ResultWrapper.Error(
                    ErrorWrapper.Server(
                        code = e.code(),
                        message = e.message(),
                        cause = e
                    )
                )
            )
        } catch (e: Throwable) {
            emit(ResultWrapper.Error(ErrorWrapper.UnknownException(e)))
        } finally {
            emit(ResultWrapper.DismissLoading)
        }
    }
}
