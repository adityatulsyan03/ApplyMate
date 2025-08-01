package com.example.applymate

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.applymate.presentation.navigation.AppNavigator
import com.example.applymate.presentation.screens.HomeScreen
import com.example.applymate.ui.theme.ApplyMateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApplyMateTheme {
                AppNavigator()
            }
        }
    }
}

@Preview
@Composable
private fun Prev() {

}