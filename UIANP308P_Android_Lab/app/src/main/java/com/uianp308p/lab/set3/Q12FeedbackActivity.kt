package com.uianp308p.lab.set3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.uianp308p.lab.R

class Q12FeedbackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q12_feedback)

        val etName = findViewById<EditText>(R.id.etFeedbackName)
        val etComments = findViewById<EditText>(R.id.etFeedbackComments)
        val btnSubmit = findViewById<Button>(R.id.btnFeedbackSubmit)

        btnSubmit.setOnClickListener {
            val name = etName.text.toString().trim()
            val comments = etComments.text.toString().trim()

            if (name.isEmpty() || comments.isEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle(R.string.dialog_error_title)
                    .setMessage("Both Name and Comments are required fields!")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton(R.string.dialog_ok, null)
                    .show()
            } else {
                Toast.makeText(
                    this,
                    "Thank you, $name! Your feedback has been submitted.",
                    Toast.LENGTH_LONG
                ).show()
                etName.text.clear()
                etComments.text.clear()
            }
        }
    }
}
