package com.darrenthiores.betrbeta.domain.di

import com.darrenthiores.betrbeta.domain.utils.dispatchers.DispatchersProvider
import com.darrenthiores.betrbeta.domain.utils.dispatchers.StandardDispatchers
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatchersModule {

    @Binds
    abstract fun provideDispatchers(
        dispatchers: StandardDispatchers
    ): DispatchersProvider
    
}