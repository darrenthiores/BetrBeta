package com.darrenthiores.betrbeta.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darrenthiores.betrbeta.domain.packages.model.PackageRequest
import com.darrenthiores.betrbeta.domain.packages.use_cases.GetPackagesByName
import com.darrenthiores.betrbeta.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPackagesByName: GetPackagesByName
): ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState>
        get() = _state.asStateFlow()

    init {
        getPackages()
    }

    private fun getPackages() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }

            val result = getPackagesByName(
                requests = listOf(
                    PackageRequest(
                        name = "com.whatsapp",
                        lastUserUpdateDare = "07/13/2023"
                    )
                )
            )

            when (result) {
                is Resource.Error -> {
                    Timber.d(result.message)

                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
                is Resource.Loading -> Unit
                is Resource.Success -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            packages = result.data ?: emptyList()
                        )
                    }
                }
            }
        }
    }
}