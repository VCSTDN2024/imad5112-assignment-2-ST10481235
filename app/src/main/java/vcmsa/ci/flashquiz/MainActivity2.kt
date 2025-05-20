package vcmsa.ci.flashquiz

import android.content.Intent
import android.os.Bundle
import android.view.Display
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.color.utilities.Score

class MainActivity2 : AppCompatActivity() {

    private val questions = arrayOf(
        "Johannesburg is one of South Africa's capitals",
        "All the presidents of South Africa have been from one party since 1994",
        "Gunpowder was invented in China",
        "The Great Pyramid of Giza is the only one of the ancient Wonders of the world that still stands",
        "Columbus was the first European to sail to the Americans"
    )
    private val answers = booleanArrayOf(false, true, true, true, false)

    private var questionIndex = 0
    private var scoreIndex = 0

    private lateinit var QuestionsTextView: TextView
    private lateinit var outputTextView: TextView
    private lateinit var NextPgbtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        QuestionsTextView = findViewById(R.id.QuestionsTextView)
        outputTextView = findViewById(R.id.outputTextView)
        NextPgbtn = findViewById(R.id.NextPgbtn)

        val TrBtn = findViewById<Button>(R.id.TrBtn)
        val FlsBtn = findViewById<Button>(R.id.FlsBtn)

        display()

        TrBtn.setOnClickListener {
            check(true)
        }

        FlsBtn.setOnClickListener {
            check(false)
        }

        NextPgbtn.setOnClickListener {
            questionIndex++
            if (questionIndex < questions.size) {
                display()
            } else {
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("Score", scoreIndex)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun display() {
        QuestionsTextView.text = questions[questionIndex]
        outputTextView.text = "" //this makes all previous feedback disappear
    }


    private fun check(userAnswer: Boolean) {
        val correctAnswer = answers[questionIndex]
        if (userAnswer == correctAnswer) {
            outputTextView.text = "That is the correct answer!"
            scoreIndex++ // the score will then increase
        } else {
            outputTextView.text = "Oops, that is incorrect."
        }

    }
}