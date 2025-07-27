package com.example.applymate.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applymate.common.UiState
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.repository.ChatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repository: ChatRepository
) : ViewModel() {

    val chatList : MutableList<String> = mutableListOf()

    private val _getReplyState = MutableStateFlow<UiState<CustomResponse<String>>>(UiState.Idle)
    val getReply = _getReplyState.asStateFlow()

    fun getReply(chat: List<String>, documentText: String){
        viewModelScope.launch {
            repository.getReply(chat,documentText).collect {
                _getReplyState.value = it
                Log.d("Debug Logs",it.toString())
            }
        }
    }

    fun reset(){
        _getReplyState.value = UiState.Idle
    }

}