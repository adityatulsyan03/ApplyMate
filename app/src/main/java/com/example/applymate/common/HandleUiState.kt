package com.example.applymate.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun <T> UiState<T>.HandleUiState(
    idleBlock: @Composable (() -> Unit)? = null,
    background: Color = MaterialTheme.colorScheme.background,
//    onCancel: () -> Unit,
//    onTryAgain: () -> Unit,
    successBlock: @Composable ((T) -> Unit)? = null
) {
    when (this) {
        is UiState.Idle -> {
            idleBlock?.let { it() }
        }

        is UiState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(background),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.padding(16.dp), color = MaterialTheme.colorScheme.primary
                )
            }
        }

        is UiState.Success -> {
            successBlock?.let { it(data) }
        }

        is UiState.Failed -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Something went wrong",
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

//        is UiState.NoDataFound -> {
//            EmptyListAnimation(onTryAgainClick = onTryAgain)
//        }
//
//        is UiState.InternetError -> {
//            InternetErrorAnimation(onTryAgainClick = onTryAgain)
//        }
//
//        is UiState.InternalServerError -> {
//            ServerErrorAnimation(
//                message = errorMessage,
//                onTryAgainClick = onTryAgain
//            )
//        }
    }
}