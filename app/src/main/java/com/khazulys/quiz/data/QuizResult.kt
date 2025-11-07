package com.khazulys.quiz.data

data class QuizResult(
    val totalQuestions: Int,
    val correctAnswers: Int,
    val wrongAnswers: Int,
    val unansweredQuestions: Int,
    val score: Int
) {
    val percentage: Float
        get() = (correctAnswers.toFloat() / totalQuestions.toFloat()) * 100f
}
