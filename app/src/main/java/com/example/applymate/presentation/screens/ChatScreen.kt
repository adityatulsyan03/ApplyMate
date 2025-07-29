package com.example.applymate.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.applymate.R
import com.example.applymate.presentation.components.chat.Questions
import com.example.applymate.presentation.components.core.DocumentUploader
import com.example.applymate.presentation.components.core.Header
import com.example.applymate.presentation.components.naviagtions.AppScaffold
import com.example.applymate.presentation.components.resume.uriToFile
import com.example.applymate.presentation.navigation.BottomNavigatorBar
import com.example.applymate.presentation.viewModel.ChatViewModel
import com.example.applymate.presentation.viewModel.DocumentViewModel
import com.example.applymate.utils.createRequestBodyFromString
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import androidx.compose.runtime.getValue
import com.example.applymate.common.UiState
import com.example.applymate.presentation.viewModel.ActivityViewModel
import com.example.applymate.presentation.components.core.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudUpload

@Composable
fun ChatScreen(
    navController: NavHostController,
    viewModel: ChatViewModel,
    documentViewModel: DocumentViewModel,
    activityViewModel: ActivityViewModel
) {

    val context = LocalContext.current
    val chatList = viewModel.chatList
    val chatState by documentViewModel.chatState.collectAsState()

    LaunchedEffect(chatState) {
        if(chatState is UiState.Success){
            activityViewModel.getTopTwoActivity()
        }
    }

    AppScaffold(
        bottomBar = {
            BottomNavigatorBar(navController)
        }
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Header(
                    first = "Document Understanding",
                    second = "Upload a document and chat with AI"
                )
                DocumentUploader(
                    image = R.drawable.upload_icon,
                    imageDesc = "Document"
                ) { fileUri ->

                    Log.d("Document Name", "Resume File Url: $fileUri")
                    val file = uriToFile(context, fileUri)
                    val fileRequestBody = file.asRequestBody("application/pdf".toMediaTypeOrNull())
                    val filePart = MultipartBody.Part.createFormData("document", file.name, fileRequestBody)

                    val type = createRequestBodyFromString("pdf")
                    val prompt = createRequestBodyFromString("Just extract the text from the document")
                    val txt = createRequestBodyFromString("")

                    documentViewModel.getDocumentText(filePart, type, prompt, txt, "chat")

                }
                when (chatState) {
                    is UiState.Loading -> {
                        LoadingState("Processing document...")
                    }
                    is UiState.Failed -> {
                        ErrorState(
                            message = (chatState as UiState.Failed).message,
                            onRetry = { /* Add retry logic if needed */ }
                        )
                    }
                    is UiState.Idle -> {
                        IdleState(
                            icon = Icons.Default.CloudUpload,
                            title = "Upload a Document",
                            subtitle = "Upload a PDF or text document to start chatting with AI about its contents"
                        )
                    }
                    is UiState.Success -> {
                        val documentText = (chatState as UiState.Success).data.data?.documentText
                        if (!documentText.isNullOrBlank()) {
                            Box(modifier = Modifier.weight(1f)) {
                                Questions(viewModel, chatList,documentText,activityViewModel)
                            }
                        } else {
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxSize()
                            ) {
                                androidx.compose.material3.Text(
                                    text = "Couldn't extract any text from the document. Please re-upload or try a different file.",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.error
                                )
                            }
                        }
                    }

                    is UiState.Idle -> {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxSize(),
                        ) {
                            androidx.compose.material3.Text(
                                text = "Please upload a document to start chatting.",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }

                    is UiState.Failed -> {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxSize()
                        ) {
                            androidx.compose.material3.Text(
                                text = "Failed to process the document. Please try again.",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    }

                    is UiState.Loading -> {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxSize()
                        ) {
                            androidx.compose.material3.Text(
                                text = "Extracting text from the document...",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }

    }

}