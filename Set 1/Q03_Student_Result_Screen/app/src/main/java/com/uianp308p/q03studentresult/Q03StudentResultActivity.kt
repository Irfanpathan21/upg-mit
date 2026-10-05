package com.uianp308p.q03studentresult

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.uianp308p.q03studentresult.R

class Q03StudentResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q03_student_result)

        val etSub1 = findViewById<EditText>(R.id.etSub1)
        val etSub2 = findViewById<EditText>(R.id.etSub2)
        val etSub3 = findViewById<EditText>(R.id.etSub3)
        val btnCalculate = findViewById<Button>(R.id.btnResultCalculate)
        val btnReset = findViewById<Button>(R.id.btnResultReset)
        val tvTotal = findViewById<TextView>(R.id.tvTotalMarks)
        val tvPercentage = findViewById<TextView>(R.id.tvPercentage)
        val tvGrade = findViewById<TextView>(R.id.tvGrade)

        btnCalculate.setOnClickListener {
            val s1Str = etSub1.text.toString().trim()
            val s2Str = etSub2.text.toString().trim()
            val s3Str = etSub3.text.toString().trim()

            if (s1Str.isEmpty() || s2Str.isEmpty() || s3Str.isEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.dialog_error_title))
                    .setMessage(getString(R.string.q03_err_empty))
                    .setPositiveButton(getString(R.string.dialog_ok), null)
                    .show()
                return@setOnClickListener
            }

            val m1 = s1Str.toDoubleOrNull() ?: 0.0
            val m2 = s2Str.toDoubleOrNull() ?: 0.0
            val m3 = s3Str.toDoubleOrNull() ?: 0.0

            if (m1 > 100 || m2 > 100 || m3 > 100) {
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.dialog_error_title))
                    .setMessage(getString(R.string.q03_err_gt100))
                    .setPositiveButton(getString(R.string.dialog_ok), null)
                    .show()
                return@setOnClickListener
            }

            val total = m1 + m2 + m3
            val percentage = total / 3.0
            val grade = when {
                percentage >= 75 -> "A (Distinction)"
                percentage >= 60 -> "B (First Class)"
                percentage >= 40 -> "C (Second Class)"
                else -> "F (Fail)"
            }

            tvTotal.text = "$total / 300"
            tvPercentage.text = "${String.format("%.2f", percentage)} %"
            tvGrade.text = grade
        }

        btnReset.setOnClickListener {
            etSub1.text.clear()
            etSub2.text.clear()
            etSub3.text.clear()
            tvTotal.text = "- / 300"
            tvPercentage.text = "- %"
            tvGrade.text = "-"
        }
    }
}
