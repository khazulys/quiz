package com.khazulys.quiz.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khazulys.quiz.ui.theme.CorrectGreen
import com.khazulys.quiz.ui.theme.TimerWarning
import com.khazulys.quiz.ui.theme.WrongRed
import com.khazulys.quiz.viewmodel.QuizViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(
    viewModel: QuizViewModel,
    onBackPressed: () -> Unit
) {
    val currentQuestion = viewModel.currentQuestion
    val timeRemaining = viewModel.timeRemaining
    val isAnswered = viewModel.isAnswered
    val selectedAnswerIndex = viewModel.selectedAnswerIndex
    val currentQuestionIndex = viewModel.currentQuestionIndex
    val totalQuestions = viewModel.totalQuestions
    val progress by animateFloatAsState(
        targetValue = viewModel.progress,
        animationSpec = tween(300),
        label = "progress"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "${viewModel.selectedCategory?.name}",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.primary
            )

            currentQuestion?.let { question ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Soal ${currentQuestionIndex + 1} dari $totalQuestions",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.primary
                        )

                        TimerChip(
                            timeRemaining = timeRemaining,
                            timeLimit = question.timeLimit
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Text(
                            text = question.question,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(16.dp),
                            lineHeight = 26.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    question.options.forEachIndexed { index, option ->
                        AnswerOption(
                            option = option,
                            index = index,
                            isSelected = selectedAnswerIndex == index,
                            isCorrect = index == question.correctAnswerIndex,
                            isAnswered = isAnswered,
                            onClick = { viewModel.selectAnswer(index) }
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {
                            if (!isAnswered) {
                                viewModel.submitAnswer()
                            } else {
                                viewModel.nextQuestion()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = if (!isAnswered) "Submit Jawaban" else {
                                if (currentQuestionIndex < totalQuestions - 1) "Soal Berikutnya" else "Lihat Hasil"
                            },
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TimerChip(
    timeRemaining: Int,
    timeLimit: Int
) {
    val backgroundColor = when {
        timeRemaining <= 5 -> WrongRed
        timeRemaining <= 10 -> TimerWarning
        else -> MaterialTheme.colorScheme.primary
    }

    Surface(
        shape = RoundedCornerShape(20.dp),
        color = backgroundColor,
        modifier = Modifier.padding(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Timer,
                contentDescription = "Timer",
                modifier = Modifier.size(20.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "$timeRemaining detik",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnswerOption(
    option: String,
    index: Int,
    isSelected: Boolean,
    isCorrect: Boolean,
    isAnswered: Boolean,
    onClick: () -> Unit
) {
    val borderColor = when {
        isAnswered && isCorrect -> CorrectGreen
        isAnswered && isSelected && !isCorrect -> WrongRed
        isSelected && !isAnswered -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.outline
    }

    val backgroundColor = when {
        isAnswered && isCorrect -> CorrectGreen.copy(alpha = 0.1f)
        isAnswered && isSelected && !isCorrect -> WrongRed.copy(alpha = 0.1f)
        isSelected && !isAnswered -> MaterialTheme.colorScheme.primaryContainer
        else -> MaterialTheme.colorScheme.surface
    }

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = { if (!isAnswered) onClick() },
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        border = BorderStroke(2.dp, borderColor),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = borderColor.copy(alpha = 0.2f),
                modifier = Modifier.size(32.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = ('A' + index).toString(),
                        fontWeight = FontWeight.Bold,
                        color = borderColor
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = option,
                fontSize = 16.sp,
                modifier = Modifier.weight(1f),
                lineHeight = 22.sp
            )

            AnimatedVisibility(visible = isAnswered && isCorrect) {
                Text(
                    text = "✓",
                    fontSize = 24.sp,
                    color = CorrectGreen,
                    fontWeight = FontWeight.Bold
                )
            }

            AnimatedVisibility(visible = isAnswered && isSelected && !isCorrect) {
                Text(
                    text = "✗",
                    fontSize = 24.sp,
                    color = WrongRed,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
