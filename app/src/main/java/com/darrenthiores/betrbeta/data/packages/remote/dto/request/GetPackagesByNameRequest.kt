package com.darrenthiores.betrbeta.data.packages.remote.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class GetPackagesByNameRequest(
    val packages: List<PackageRequest>
) {
    @Serializable
    data class PackageRequest(
        val name: String,
        val lastUserUpdateDate: String
    )
}
