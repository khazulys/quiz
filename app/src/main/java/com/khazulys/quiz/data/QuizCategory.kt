package com.khazulys.quiz.data

data class QuizCategory(
    val id: String,
    val name: String,
    val description: String,
    val icon: String,
    val questions: List<Question>
)
