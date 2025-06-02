package com.example.fetchrewards.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchrewards.api.HiringResponse
import com.example.fetchrewards.api.ServiceResult
import com.example.fetchrewards.database.entity.HiringItem
import com.example.fetchrewards.repository.HiringRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HiringViewModel @Inject constructor(
    private val hiringRepository: HiringRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<HiringListUiState>(HiringListUiState())
    val uiState: StateFlow<HiringListUiState> = _uiState.asStateFlow()

    init {
        fetchHiringList()
    }

    /**
     * Fetch the Hiring list from repository and provide the sorted list
     * */
    private fun fetchHiringList() {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val result = hiringRepository.getHiringList()
            when (result) {
                is ServiceResult.Success -> {
                    _uiState.update {
                        val sortedData = result.data
                            .filter { !it.name.isNullOrBlank() }
                            .sortedWith(compareBy({ it.listId }, { it.name }))
                        it.copy(
                            isLoading = false,
                            hiringList = sortedData,
                            errorMessage = null
                        )
                    }
                }

                is ServiceResult.Error -> {
                    _uiState.update {
                        it.copy(isLoading = false, errorMessage = result.message)
                    }
                }
            }
        }
    }

    fun getItemDetails(itemId: Int): HiringItem? {
        return _uiState.value.hiringList.find { it.id == itemId }
    }

    fun sortWith(type: String) {
        val list = _uiState.value.hiringList
        val sortedList = when (type.lowercase()) {
            "name" -> list.sortedBy { it.name }
            "id" -> list.sortedBy { it.id }
            "listid" -> list.sortedBy { it.listId }
            else -> list
        }
        _uiState.update {
            it.copy(hiringList = sortedList)
        }
    }
}


/**
 * UI State object for the Screen
 * to provide different ui stated
 * */
data class HiringListUiState(
    val isLoading: Boolean = false,
    val hiringList: List<HiringItem> = emptyList(),
    val errorMessage: String? = null
)