package com.example.applymate.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.applymate.R
import com.example.applymate.presentation.components.chat.Questions
import com.example.applymate.presentation.components.core.DocumentUploader
import com.example.applymate.presentation.components.core.Header
import com.example.applymate.presentation.components.naviagtions.AppScaffold
import com.example.applymate.presentation.components.naviagtions.TopBar
import com.example.applymate.presentation.navigation.BottomNavigatorBar

@Composable
fun ChatScreen(navController: NavHostController) {

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
            LazyColumn(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                item {
                    Header(
                        first = "Document Understanding",
                        second = "Upload a document and chat with AI"
                    )
                }
                item {
                    DocumentUploader(
                        image = R.drawable.upload_icon,
                        imageDesc = "Document"
                    ) { fileUri ->

                        Log.d("Document Name", "Resume File Url: $fileUri")

                    }
                }
                item { Questions() }
            }
        }

    }

}