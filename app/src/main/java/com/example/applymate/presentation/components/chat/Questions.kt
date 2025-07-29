package com.example.applymate.presentation.components.chat

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.applymate.common.UiState
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.presentation.viewModel.ActivityViewModel
import com.example.applymate.presentation.viewModel.ChatViewModel
import com.example.applymate.ui.theme.LightBackground
import com.example.applymate.utils.MarkdownText
import androidx.compose.material3.MaterialTheme

@Composable
fun Questions(
    viewModel: ChatViewModel,
    chatList: MutableList<String>,
    documentText: String,
    activityViewModel: ActivityViewModel
) {
    var prompt by remember { mutableStateOf("") }
    val getReplyState by viewModel.getReply.collectAsState()

    val listState = rememberLazyListState()

    if(chatList.isNotEmpty())
        LaunchedEffect(chatList.size) {
            listState.animateScrollToItem(chatList.lastIndex)
        }

    when(getReplyState) {
        is UiState.Success -> {
            val txt = (getReplyState as UiState.Success<CustomResponse<String>>).data.data
            Log.d("Debug Logs",txt.toString())
            chatList.add(txt?:"Retry Again")
            viewModel.reset()
        }
        else -> {
            "Retry Again"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBackground)
            .padding(8.dp)
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(chatList) { index, message ->
                val isUser = index % 2 == 0
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = if (isUser) Arrangement.End else Arrangement.Start
                ) {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = if (isUser) Color(0xFFD1E8FF) else Color.White
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.widthIn(max = 300.dp)
                    ) {
                        if (isUser) {
                            Text(
                                text = message,
                                modifier = Modifier.padding(12.dp),
                                color = Color.Black
                            )
                        } else {
                            Box(modifier = Modifier.padding(12.dp)) {
                                MarkdownText(
                                    text = message
                                )
                            }
                        }
                    }
                }
            }
            item{
                if(getReplyState is UiState.Loading){
                    Text("Loading...")
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                .background(Color.White, shape = RoundedCornerShape(24.dp))
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = prompt,
                onValueChange = { prompt = it },
                placeholder = { Text("Type your message...") },
                modifier = Modifier.weight(1f),
                maxLines = 3,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                )
            )
            IconButton(
                onClick = {
                    val newChatList = chatList
                    newChatList.add(prompt)
                    viewModel.getReply(chat = newChatList, documentText = documentText)
                    prompt = ""
                },
                enabled = prompt != "",
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Send",
                    tint = Color.Black
                )
            }
        }
    }
}