package com.darrenthiores.betrbeta.data.packages.di

import com.darrenthiores.betrbeta.data.packages.repository.PackagesRepositoryImpl
import com.darrenthiores.betrbeta.domain.packages.repository.PackagesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(
    includes = [
        PackagesNetworkModule::class
    ]
)
@InstallIn(SingletonComponent::class)
abstract class PackagesRepositoryModule {
    @Binds
    abstract fun provideRepository(repository: PackagesRepositoryImpl): PackagesRepository
}