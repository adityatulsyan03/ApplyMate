package com.example.applymate.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.applymate.presentation.components.core.Header
import com.example.applymate.presentation.components.naviagtions.AppScaffold
import com.example.applymate.presentation.components.naviagtions.TopBar
import com.example.applymate.presentation.components.referral.GenerateReferralMessage
import com.example.applymate.presentation.components.referral.ReferralKeywords
import com.example.applymate.presentation.navigation.BottomNavigatorBar

@Composable
fun ReferralScreen(navController: NavHostController) {

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
                    item { ReferralKeywords() }
                }
                GenerateReferralMessage(modifier = Modifier.align(Alignment.BottomCenter))
            }
        }

    }

}