package com.example.applymate.presentation.viewModel

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applymate.common.UiState
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.ResumeImproveText
import com.example.applymate.data.model.ResumeText
import com.example.applymate.data.model.Suggestions
import com.example.applymate.data.repository.ResumeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResumeViewModel @Inject constructor(
    private val resumeRepository: ResumeRepository
) : ViewModel() {

    private val _improveResumeState = MutableStateFlow<UiState<CustomResponse<List<Suggestions>>>>(UiState.Idle)
    val improveResumeState = _improveResumeState.asStateFlow()

    fun improveResume(resumeImproveText: ResumeImproveText){
        viewModelScope.launch {
            resumeRepository.improveResume(resumeImproveText).collect {
                _improveResumeState.value = it
                Log.d("Debug Logs",it.toString())
            }
        }
    }

}