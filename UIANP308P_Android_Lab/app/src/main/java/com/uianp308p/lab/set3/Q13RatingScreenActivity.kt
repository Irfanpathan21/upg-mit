package com.uianp308p.lab.set3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.uianp308p.lab.R

class Q13RatingScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q13_rating)

        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val etComments = findViewById<EditText>(R.id.etRatingComments)
        val btnSubmit = findViewById<Button>(R.id.btnSubmitRating)
        val tvDisplay = findViewById<TextView>(R.id.tvRatingDisplay)

        btnSubmit.setOnClickListener {
            val stars = ratingBar.rating.toInt()
            val comments = etComments.text.toString().trim()

            if (stars < 3) {
                // Low rating (< 3): Show red text in TextView and AlertDialog inquiry
                tvDisplay.text = "Submitted Rating: $stars / 5 Stars\nComments: ${if (comments.isNotEmpty()) comments else "None"}"
                tvDisplay.setTextColor(ContextCompat.getColor(this, R.color.color_error))

                AlertDialog.Builder(this)
                    .setTitle("Feedback Inquiry")
                    .setMessage(getString(R.string.q13_ask_more) + "\nWe are sorry your experience was under 3 stars.")
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setPositiveButton("Yes") { _, _ ->
                        etComments.requestFocus()
                    }
                    .setNegativeButton("No", null)
                    .show()
            } else {
                // High rating (>= 3): Show Toast and update TextView in Green
                tvDisplay.text = "Submitted Rating: $stars / 5 Stars\nComments: ${if (comments.isNotEmpty()) comments else "None"}"
                tvDisplay.setTextColor(ContextCompat.getColor(this, R.color.color_success))

                Toast.makeText(
                    this,
                    "Thank you! Rating: $stars/5\nComments: $comments",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
