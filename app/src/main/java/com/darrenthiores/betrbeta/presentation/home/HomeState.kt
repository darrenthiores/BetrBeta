package com.darrenthiores.betrbeta.presentation.home

import com.darrenthiores.betrbeta.domain.packages.model.Package

data class HomeState(
    val packages: List<Package> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
