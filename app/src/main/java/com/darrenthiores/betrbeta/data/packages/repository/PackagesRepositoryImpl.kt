package com.darrenthiores.betrbeta.data.packages.repository

import com.darrenthiores.betrbeta.data.packages.mapper.toPackageRequest
import com.darrenthiores.betrbeta.data.packages.mapper.toPackages
import com.darrenthiores.betrbeta.data.packages.remote.PackagesRemoteDataSource
import com.darrenthiores.betrbeta.data.packages.remote.dto.request.GetPackagesByNameRequest
import com.darrenthiores.betrbeta.data.utils.ApiResponse
import com.darrenthiores.betrbeta.domain.packages.model.Package
import com.darrenthiores.betrbeta.domain.packages.model.PackageRequest
import com.darrenthiores.betrbeta.domain.packages.repository.PackagesRepository
import com.darrenthiores.betrbeta.domain.utils.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PackagesRepositoryImpl @Inject constructor(
    private val remoteDataSource: PackagesRemoteDataSource
): PackagesRepository {
    override suspend fun getPackagesByName(
        requests: List<PackageRequest>
    ): Resource<List<Package>> {
        val apiRequest = GetPackagesByNameRequest(
            packages = requests.map { it.toPackageRequest() }
        )
        val response = remoteDataSource
            .getPackagesByName(
                request = apiRequest
            )

        return when (response) {
            ApiResponse.Empty -> Resource.Error("Unknown Error")
            is ApiResponse.Error -> Resource.Error(response.errorMessage)
            is ApiResponse.Success -> Resource.Success(
                data = response.data.toPackages()
            )
        }
    }
}