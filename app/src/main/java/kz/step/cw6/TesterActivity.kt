package kz.step.cw6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TesterActivity : AppCompatActivity() {
    private var questions: MutableList<Question>? = null
    var questionTextView: TextView? = null
    var resultTextView: TextView? = null
    var firstVariantButton: Button? = null
    var secondVariantButton: Button? = null
    var thirdVariantButton: Button? = null
    var fourthVariantButton: Button? = null
    var currentQuestion = 0
    var correctAnswers = 0
    var isLast = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tester)
        setQuestions()
        initializeViews()
        initializeListeners()
    }

    private fun setQuestions() {
        questions = mutableListOf(Question(), Question(),Question())
        questions!![0].text = "2+2?"
        questions!![0].variants = arrayOf("1", "2", "3", "4")
        questions!![0].setCorrectAnswer("4")
        questions!![0].shuffleVariants()

        questions!![1].text = "2+5?"
        questions!![1].variants = arrayOf("7", "8", "9", "11")
        questions!![1].setCorrectAnswer("7")
        questions!![1].shuffleVariants()

        questions!![2].text = "5+5?"
        questions!![2].variants = arrayOf("123", "15", "16", "10")
        questions!![2].setCorrectAnswer("10")
        questions!![2].shuffleVariants()

    }

    private fun initializeViews() {
        questionTextView = findViewById(R.id.text_view_tester_activity_question)
        resultTextView = findViewById(R.id.text_view_tester_activity_result)
        firstVariantButton = findViewById(R.id.button_tester_activity_first)
        secondVariantButton = findViewById(R.id.button_tester_activity_second)
        thirdVariantButton = findViewById(R.id.button_tester_activity_third)
        fourthVariantButton = findViewById(R.id.button_tester_activity_fourth)
    }

    private fun initializeListeners() {
        val buttons = mutableListOf(this.firstVariantButton, this.secondVariantButton, this.thirdVariantButton, this.fourthVariantButton)
        changeQuestion()
        for (btn in buttons) {
            btn?.setOnClickListener {
                if (questions!![currentQuestion].checkAnswer(btn.text.toString()) && !isLast) {
                    correctAnswers++
                }
                if (currentQuestion + 1 != questions!!.size) {
                    currentQuestion++
                } else {
                    var size = questions!!.size
                    resultTextView?.text = "Поздравляю, ваш результат: $correctAnswers из $size"
                    isLast = true
                }
                changeQuestion()
            }
        }
    }

    private fun changeQuestion() {
        val buttons = mutableListOf(this.firstVariantButton, this.secondVariantButton, this.thirdVariantButton, this.fourthVariantButton)

        for ((i, btn) in buttons.withIndex()) {
            questionTextView?.text = questions!![currentQuestion].text
            btn?.text = questions!![currentQuestion].variants[i]
        }
    }


}