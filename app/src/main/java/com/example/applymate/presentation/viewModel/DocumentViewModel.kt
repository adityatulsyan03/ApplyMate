package com.example.applymate.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applymate.common.UiState
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.ResumeText
import com.example.applymate.data.repository.DocumentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

@HiltViewModel
class DocumentViewModel @Inject constructor(
    private val repository: DocumentRepository
) : ViewModel() {

    private val _resumeState = MutableStateFlow<UiState<CustomResponse<ResumeText>>>(UiState.Idle)
    val resumeState = _resumeState.asStateFlow()

    private val _jdState = MutableStateFlow<UiState<CustomResponse<ResumeText>>>(UiState.Idle)
    val jdState = _jdState.asStateFlow()

    private val _chatState = MutableStateFlow<UiState<CustomResponse<ResumeText>>>(UiState.Idle)
    val chatState = _chatState.asStateFlow()

    fun getDocumentText(
        document: MultipartBody.Part,
        documentType: RequestBody,
        prompt: RequestBody,
        txt: RequestBody,
        type: String
    ) {
        viewModelScope.launch {
            repository.getDocumentText(document, documentType, prompt, txt).collect { response ->
                Log.d("Debug Logs","Resume getDocumentText VM")
                if (type == "resume") _resumeState.value = response
                if (type == "jd") _jdState.value = response
                if (type == "chat") _chatState.value = response
            }
        }
    }
}