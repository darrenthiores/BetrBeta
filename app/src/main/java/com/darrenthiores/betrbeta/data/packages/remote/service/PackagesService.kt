package com.darrenthiores.betrbeta.data.packages.remote.service

import com.darrenthiores.betrbeta.BuildConfig
import com.darrenthiores.betrbeta.data.packages.remote.dto.request.GetPackagesByNameRequest
import com.darrenthiores.betrbeta.data.packages.remote.dto.response.PackagesResponse

interface PackagesService {

    suspend fun getPackagesByName(
        request: GetPackagesByNameRequest
    ): PackagesResponse

    companion object {
        private const val BASE_URL = "https://${BuildConfig.BASE_URL}"
        const val GET_PACKAGES_BY_NAME = "$BASE_URL/api/packagesByNames"
    }
}