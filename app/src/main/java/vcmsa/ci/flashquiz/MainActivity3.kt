package vcmsa.ci.flashquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val score= intent.getIntExtra("score", 0)

        val ScorePgTextView= findViewById<TextView>(R.id.ScorePgtextView)
        val outputTextView2= findViewById<TextView>(R.id.outputtextView2)

        ScorePgTextView.text= "You scored $score out of 5"
        outputTextView2.text= if (score >= 3) "Well done on your score!" else "You got it next time!"

        findViewById<Button>(R.id.Reviewbtn).setOnClickListener {
            val intent= Intent(this, MainActivity3::class.java)
            startActivity(intent)

        }

        findViewById<Button>(R.id.Backbtn).setOnClickListener {
            finishAffinity()
        }


        val questions= arrayOf(
            "Johannesburg is one of South Africa's capitals",
            "All the presidents of South Africa have been from one party since 1994",
            "Gunpowder was invented in China",
            "The Great Pyramid of Giza is the only one of the ancient Wonders of the world that still stands",
            "Columbus was the first European to sail to the Americans"
        )
        val answers= booleanArrayOf(false, true, true, true, false)

        val builder= StringBuilder()
        for (i in questions.indices) {
            builder.append("${i + 1}. ${questions[i]}\nAnswer: ${answers[i]}\n\n")
        }

        outputTextView2.text= builder.toString()
    }
}