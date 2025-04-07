package com.example.applymate.presentation.navigation

sealed class Screens(val route: String){

    data object DashBoardScreen: Screens("dashboard_screen")
    data object ReferralMessageGeneratorScreen: Screens("referral_message_generator_screen")
    data object ResumeOptimizationScreen: Screens("resume_optimization_screen")
    data object CoverLetterGeneratorScreen: Screens("cover_letter_generator_screen")
    data object JobSearchScreen: Screens("job_search_screen")
    data object LinkedInScreen: Screens("linkedin_screen")
    data object ResumeScreen: Screens("resume_screen")

}