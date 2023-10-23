package com.darrenthiores.betrbeta.data.packages.remote

import com.darrenthiores.betrbeta.data.packages.remote.dto.request.GetPackagesByNameRequest
import com.darrenthiores.betrbeta.data.packages.remote.dto.response.PackagesResponse
import com.darrenthiores.betrbeta.data.packages.remote.service.PackagesService
import com.darrenthiores.betrbeta.data.utils.ApiResponse
import com.darrenthiores.betrbeta.data.utils.tryCatch
import com.darrenthiores.betrbeta.domain.utils.dispatchers.DispatchersProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PackagesRemoteDataSource @Inject constructor(
    private val apiService: PackagesService,
    private val dispatchers: DispatchersProvider
) {
    suspend fun getPackagesByName(
        request: GetPackagesByNameRequest
    ): ApiResponse<PackagesResponse> {
        return withContext(dispatchers.io) {
            tryCatch {
                val result = apiService.getPackagesByName(
                    request = request
                )

                ApiResponse.Success(result)
            }
        }
    }
}