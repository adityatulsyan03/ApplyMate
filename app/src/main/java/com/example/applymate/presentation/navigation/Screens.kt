package com.example.applymate.presentation.navigation

sealed class Screens(val route: String){

    data object HomeScreen: Screens("home_screen")
    data object JobScreen: Screens("job_screen")
    data object ResumeScreen: Screens("resume_screen")
    data object ChatScreen: Screens("chat_screen")
    data object ReferralScreen: Screens("referral_screen")

}