package com.example.applymate.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applymate.common.UiState
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.RecentActivity
import com.example.applymate.data.repository.ActivityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel @Inject constructor(
    private val repository: ActivityRepository
) : ViewModel() {

    private val _getTopTwoActivityState = MutableStateFlow<UiState<CustomResponse<List<RecentActivity>>>>(UiState.Idle)
    val getTopTwoActivityState = _getTopTwoActivityState.asStateFlow()

    fun getTopTwoActivity(){
        viewModelScope.launch {
            repository.getTopTwoActivity().collect {
                _getTopTwoActivityState.value = it
                Log.d("Debug Logs",it.toString())
            }
        }
    }

}