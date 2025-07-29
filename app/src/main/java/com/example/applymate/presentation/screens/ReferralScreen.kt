package com.example.applymate.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.applymate.common.UiState
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.Referral
import com.example.applymate.presentation.components.core.Header
import com.example.applymate.presentation.components.naviagtions.AppScaffold
import com.example.applymate.presentation.components.referral.GenerateReferralMessage
import com.example.applymate.presentation.components.referral.ReferralKeywords
import com.example.applymate.presentation.navigation.BottomNavigatorBar
import com.example.applymate.presentation.viewModel.ActivityViewModel
import com.example.applymate.presentation.viewModel.ReferralViewModel
import com.example.applymate.utils.MarkdownText
import com.example.applymate.presentation.components.core.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit

@Composable
fun ReferralScreen(
    navController: NavHostController,
    viewModel: ReferralViewModel,
    activityViewModel: ActivityViewModel
) {

    var jobTitle by remember { mutableStateOf("") }
    var company by remember { mutableStateOf("") }
    var contactPerson by remember { mutableStateOf("") }
    var additionalNotes by remember { mutableStateOf("") }

    val referralContent = Referral(
        jobTitle = jobTitle,
        companyName = company,
        contactPersonName = contactPerson,
        additionalNotes = additionalNotes
    )

    val referralState by viewModel.referralMessageState.collectAsState()

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
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    contentPadding = PaddingValues(bottom = 80.dp)
                ) {
                    item {
                        Header(
                            first = "Referral Message Generator",
                            second = "Generate a referral message to apply"
                        )
                    }
                    item {
                        ReferralKeywords(
                            jobTitle = jobTitle,
                            onJobTitleChange = { jobTitle = it },
                            company = company,
                            onCompanyChange = { company = it },
                            contactPerson = contactPerson,
                            onContactPersonChange = { contactPerson = it },
                            additionalNotes = additionalNotes,
                            onAdditionalNotesChange = { additionalNotes = it },
                        )
                    }
                    when (referralState) {
                        is UiState.Loading -> {
                            item {
                                LoadingState("Generating referral message...")
                            }
                        }

                        is UiState.Failed -> {
                            val errorMessage = (referralState as UiState.Failed).message
                            item {
                                ErrorState(
                                    message = errorMessage,
                                    onRetry = { viewModel.generateReferralMessage(referralContent) }
                                )
                            }
                        }

                        is UiState.Idle -> {
                            item {
                                IdleState(
                                    icon = Icons.Default.Edit,
                                    title = "Generate Referral Message",
                                    subtitle = "Fill in the job details above and click generate to create a personalized referral message"
                                )
                            }
                        }

                        is UiState.Success -> {
                            val message = (referralState as UiState.Success<CustomResponse<String>>).data.data
                            if (!message.isNullOrBlank()) {
                                item {
                                    MarkdownText(
                                        text = message
                                    )
                                }
                            } else {
                                item {
                                    Text(
                                        text = "Failed to generate referral message. Please try again.",
                                        modifier = Modifier.fillMaxWidth(),
                                        color = MaterialTheme.colorScheme.error,
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                }
                            }
                        }
                    }
                }
                GenerateReferralMessage(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    referralContent = referralContent,
                    onGenerateClick = {
                        Log.d("Debug Logs",it.toString())
                        viewModel.generateReferralMessage(it)
                    },
                    activityViewModel = activityViewModel
                )
            }
        }

    }

}