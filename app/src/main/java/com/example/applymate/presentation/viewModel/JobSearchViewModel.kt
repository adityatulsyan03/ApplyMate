package com.example.applymate.presentation.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applymate.common.UiState
import com.example.applymate.data.enums.ExperienceLevel
import com.example.applymate.data.enums.TimeUnit
import com.example.applymate.data.enums.WorkType
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.JobSearch
import com.example.applymate.data.repository.JobSearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JobSearchViewModel @Inject constructor(
    private val repository: JobSearchRepository
) : ViewModel() {

    var searchText = mutableStateOf("")
    var selectedTimeValue = mutableStateOf("1")
    var selectedTimeUnit = mutableStateOf(TimeUnit.Hours)
    val selectedWorkTypes = mutableStateListOf<WorkType>()
    val selectedExperienceLevels = mutableStateListOf<ExperienceLevel>()
    var isEasyApplyEnabled = mutableStateOf(false)
    var isVerificationEnabled = mutableStateOf(false)
    var isInYourNetworkEnabled = mutableStateOf(false)
    var isNoOfApplicantsEnabled = mutableStateOf(false)

    private val _getJobQueryState = MutableStateFlow<UiState<CustomResponse<String>>>(UiState.Idle)
    val getJobQueryState = _getJobQueryState.asStateFlow()

    fun getJobQuery(jobSearch: JobSearch){
        viewModelScope.launch {
            repository.getJobQuery(jobSearch).collect {
                _getJobQueryState.value = it
                Log.d("Debug Logs",it.toString())
            }
        }
    }

    fun reset() {
        _getJobQueryState.value = UiState.Idle
    }

}