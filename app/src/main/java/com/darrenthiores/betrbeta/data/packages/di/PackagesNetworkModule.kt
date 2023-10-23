package com.darrenthiores.betrbeta.data.packages.di

import com.darrenthiores.betrbeta.data.packages.remote.service.KtorPackagesService
import com.darrenthiores.betrbeta.data.packages.remote.service.PackagesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PackagesNetworkModule {
    @Singleton
    @Provides
    fun provideKtorPackagesApiService(
        client: HttpClient
    ): PackagesService = KtorPackagesService(
        client = client
    )
}