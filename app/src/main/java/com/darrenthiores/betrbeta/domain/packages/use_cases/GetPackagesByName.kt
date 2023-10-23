package com.darrenthiores.betrbeta.domain.packages.use_cases

import com.darrenthiores.betrbeta.domain.packages.model.Package
import com.darrenthiores.betrbeta.domain.packages.model.PackageRequest
import com.darrenthiores.betrbeta.domain.packages.repository.PackagesRepository
import com.darrenthiores.betrbeta.domain.utils.Resource
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetPackagesByName @Inject constructor(
    private val repository: PackagesRepository
) {
    suspend operator fun invoke(
        requests: List<PackageRequest>
    ): Resource<List<Package>> {
        return repository
            .getPackagesByName(
                requests = requests
            )
    }
}