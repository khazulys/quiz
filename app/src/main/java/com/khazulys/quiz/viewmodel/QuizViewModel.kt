package com.khazulys.quiz.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khazulys.quiz.data.Question
import com.khazulys.quiz.data.QuizCategory
import com.khazulys.quiz.data.QuizResult
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuizViewModel : ViewModel() {
    
    var selectedCategory by mutableStateOf<QuizCategory?>(null)
        private set
    
    var currentQuestionIndex by mutableIntStateOf(0)
        private set
    
    var selectedAnswerIndex by mutableIntStateOf(-1)
        private set
    
    var timeRemaining by mutableIntStateOf(30)
        private set
    
    var isAnswered by mutableStateOf(false)
        private set
    
    var correctAnswers by mutableIntStateOf(0)
        private set
    
    var wrongAnswers by mutableIntStateOf(0)
        private set
    
    var unansweredQuestions by mutableIntStateOf(0)
        private set
    
    var isQuizFinished by mutableStateOf(false)
        private set
    
    private var timerJob: Job? = null
    
    val currentQuestion: Question?
        get() = selectedCategory?.questions?.getOrNull(currentQuestionIndex)
    
    val totalQuestions: Int
        get() = selectedCategory?.questions?.size ?: 0
    
    val progress: Float
        get() = if (totalQuestions > 0) (currentQuestionIndex + 1).toFloat() / totalQuestions.toFloat() else 0f
    
    fun selectCategory(category: QuizCategory) {
        selectedCategory = category
        resetQuiz()
    }
    
    fun selectAnswer(index: Int) {
        if (!isAnswered) {
            selectedAnswerIndex = index
        }
    }
    
    fun submitAnswer() {
        if (isAnswered) return
        
        isAnswered = true
        stopTimer()
        
        currentQuestion?.let { question ->
            when {
                selectedAnswerIndex == -1 -> {
                    unansweredQuestions++
                }
                selectedAnswerIndex == question.correctAnswerIndex -> {
                    correctAnswers++
                }
                else -> {
                    wrongAnswers++
                }
            }
        }
    }
    
    fun nextQuestion() {
        if (currentQuestionIndex < totalQuestions - 1) {
            currentQuestionIndex++
            selectedAnswerIndex = -1
            isAnswered = false
            startTimer()
        } else {
            finishQuiz()
        }
    }
    
    private fun startTimer() {
        timeRemaining = currentQuestion?.timeLimit ?: 30
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (timeRemaining > 0 && !isAnswered) {
                delay(1000)
                timeRemaining--
            }
            if (timeRemaining == 0 && !isAnswered) {
                submitAnswer()
            }
        }
    }
    
    private fun stopTimer() {
        timerJob?.cancel()
    }
    
    private fun finishQuiz() {
        isQuizFinished = true
        stopTimer()
    }
    
    fun resetQuiz() {
        currentQuestionIndex = 0
        selectedAnswerIndex = -1
        timeRemaining = 30
        isAnswered = false
        correctAnswers = 0
        wrongAnswers = 0
        unansweredQuestions = 0
        isQuizFinished = false
        startTimer()
    }
    
    fun getQuizResult(): QuizResult {
        val score = (correctAnswers * 100) / totalQuestions
        return QuizResult(
            totalQuestions = totalQuestions,
            correctAnswers = correctAnswers,
            wrongAnswers = wrongAnswers,
            unansweredQuestions = unansweredQuestions,
            score = score
        )
    }
    
    fun backToHome() {
        selectedCategory = null
        isQuizFinished = false
        stopTimer()
    }
    
    override fun onCleared() {
        super.onCleared()
        stopTimer()
    }
}
