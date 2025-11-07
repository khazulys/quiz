package com.khazulys.quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khazulys.quiz.ui.screens.HomeScreen
import com.khazulys.quiz.ui.screens.QuizScreen
import com.khazulys.quiz.ui.screens.SummaryScreen
import com.khazulys.quiz.ui.theme.QuizTheme
import com.khazulys.quiz.viewmodel.QuizViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuizApp()
                }
            }
        }
    }
}

@Composable
fun QuizApp(
    viewModel: QuizViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                onCategorySelected = { category ->
                    viewModel.selectCategory(category)
                    navController.navigate("quiz")
                }
            )
        }

        composable("quiz") {
            if (viewModel.isQuizFinished) {
                SummaryScreen(
                    viewModel = viewModel,
                    onRestartQuiz = {
                        viewModel.resetQuiz()
                    },
                    onBackToHome = {
                        viewModel.backToHome()
                        navController.navigate("home") {
                            popUpTo("home") { inclusive = true }
                        }
                    }
                )
            } else {
                QuizScreen(
                    viewModel = viewModel,
                    onBackPressed = {
                        viewModel.backToHome()
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
