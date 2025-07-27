package com.example.applymate.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applymate.common.UiState
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.Referral
import com.example.applymate.data.repository.ReferralRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReferralViewModel @Inject constructor(
    private val repository: ReferralRepository
) : ViewModel() {

    private val _referralMessageState = MutableStateFlow<UiState<CustomResponse<String>>>(UiState.Idle)
    val referralMessageState = _referralMessageState.asStateFlow()

    fun generateReferralMessage(referralContent: Referral) {
        viewModelScope.launch {
            repository.getReferralMsg(referralContent).collect {
                _referralMessageState.value = it
                Log.d("Debug Logs",it.toString())
            }
        }
    }

}