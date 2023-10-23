package com.darrenthiores.betrbeta.data.packages.remote.service

import com.darrenthiores.betrbeta.data.packages.remote.dto.request.GetPackagesByNameRequest
import com.darrenthiores.betrbeta.data.packages.remote.dto.response.PackagesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType

class KtorPackagesService(
    private val client: HttpClient
): PackagesService {
    override suspend fun getPackagesByName(request: GetPackagesByNameRequest): PackagesResponse {
        val result = client.post {
            url(PackagesService.GET_PACKAGES_BY_NAME)
            contentType(ContentType.Application.Json)

            setBody(request)
        }

        return result.body()
    }
}