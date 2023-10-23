package com.darrenthiores.betrbeta.domain.packages.repository

import com.darrenthiores.betrbeta.domain.packages.model.Package
import com.darrenthiores.betrbeta.domain.packages.model.PackageRequest
import com.darrenthiores.betrbeta.domain.utils.Resource

interface PackagesRepository {
    suspend fun getPackagesByName(
        requests: List<PackageRequest>
    ): Resource<List<Package>>
}