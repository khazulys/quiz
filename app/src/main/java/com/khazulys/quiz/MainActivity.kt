package com.khazulys.quiz

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.khazulys.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentQuestionIndex = 0
    private var score = 0
    private var hasAnswered = false

    private val questions = listOf(
        Question(
            "What is the capital of Indonesia?",
            listOf("Bandung", "Jakarta", "Surabaya", "Medan"),
            1
        ),
        Question(
            "Which programming language is used for Android development?",
            listOf("Python", "JavaScript", "Kotlin", "Ruby"),
            2
        ),
        Question(
            "What year did Indonesia gain independence?",
            listOf("1942", "1945", "1950", "1960"),
            1
        ),
        Question(
            "What is 15 + 27?",
            listOf("32", "42", "52", "62"),
            1
        ),
        Question(
            "Which planet is known as the Red Planet?",
            listOf("Venus", "Mars", "Jupiter", "Saturn"),
            1
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayQuestion()

        binding.btnNext.setOnClickListener {
            if (!hasAnswered) {
                checkAnswer()
            } else {
                moveToNextQuestion()
            }
        }

        binding.btnRestart.setOnClickListener {
            restartQuiz()
        }

        binding.radioGroupAnswers.setOnCheckedChangeListener { _, _ ->
            if (hasAnswered) {
                binding.radioGroupAnswers.clearCheck()
                hasAnswered = false
                binding.tvFeedback.text = ""
                binding.btnNext.text = getString(R.string.submit_button)
            }
        }
    }

    private fun displayQuestion() {
        val question = questions[currentQuestionIndex]
        binding.tvQuestionNumber.text = getString(
            R.string.question_text,
            currentQuestionIndex + 1,
            questions.size
        )
        binding.tvQuestion.text = question.text
        binding.rbOption1.text = question.options[0]
        binding.rbOption2.text = question.options[1]
        binding.rbOption3.text = question.options[2]
        binding.rbOption4.text = question.options[3]
        binding.radioGroupAnswers.clearCheck()
        binding.tvFeedback.text = ""
        hasAnswered = false
        binding.btnNext.text = getString(R.string.submit_button)
    }

    private fun checkAnswer() {
        val selectedId = binding.radioGroupAnswers.checkedRadioButtonId
        if (selectedId == -1) {
            Snackbar.make(binding.root, "Please select an answer", Snackbar.LENGTH_SHORT).show()
            return
        }

        val selectedRadioButton = findViewById<RadioButton>(selectedId)
        val selectedIndex = binding.radioGroupAnswers.indexOfChild(selectedRadioButton)
        val correctIndex = questions[currentQuestionIndex].correctAnswerIndex

        hasAnswered = true

        if (selectedIndex == correctIndex) {
            score++
            binding.tvFeedback.text = getString(R.string.correct_answer)
            binding.tvFeedback.setTextColor(Color.parseColor("#4CAF50"))
        } else {
            binding.tvFeedback.text = getString(R.string.wrong_answer)
            binding.tvFeedback.setTextColor(Color.parseColor("#F44336"))
        }

        if (currentQuestionIndex < questions.size - 1) {
            binding.btnNext.text = getString(R.string.next_button)
        } else {
            binding.btnNext.text = "Show Results"
        }
    }

    private fun moveToNextQuestion() {
        currentQuestionIndex++
        if (currentQuestionIndex < questions.size) {
            displayQuestion()
        } else {
            showResults()
        }
    }

    private fun showResults() {
        binding.tvQuestionNumber.visibility = View.GONE
        binding.tvQuestion.visibility = View.GONE
        binding.radioGroupAnswers.visibility = View.GONE
        binding.tvFeedback.visibility = View.GONE
        binding.btnNext.visibility = View.GONE
        
        binding.layoutScore.visibility = View.VISIBLE
        binding.tvScore.text = getString(R.string.score_text, score, questions.size)
    }

    private fun restartQuiz() {
        currentQuestionIndex = 0
        score = 0
        hasAnswered = false
        
        binding.tvQuestionNumber.visibility = View.VISIBLE
        binding.tvQuestion.visibility = View.VISIBLE
        binding.radioGroupAnswers.visibility = View.VISIBLE
        binding.tvFeedback.visibility = View.VISIBLE
        binding.btnNext.visibility = View.VISIBLE
        binding.layoutScore.visibility = View.GONE
        
        displayQuestion()
    }
}

data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)
