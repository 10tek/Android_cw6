package kz.step.cw6

class Question {
    private var _correctAnswer: String? = null
    var text: String? = null
    var variants: Array<String> = arrayOf("", "", "", "")

    fun setCorrectAnswer(answer: String) {
        _correctAnswer = answer
    }

    fun checkAnswer(answer: String): Boolean {
        return _correctAnswer == answer
    }

    fun shuffleVariants(): Array<String> {
        for (i in 0..10) {
            for (i in 0..3) {
                val randomIndex = (0..3).random()
                val tmp = variants[i]
                variants[i] = variants[randomIndex]
                variants[randomIndex] = tmp
            }
        }

        return variants
    }
}