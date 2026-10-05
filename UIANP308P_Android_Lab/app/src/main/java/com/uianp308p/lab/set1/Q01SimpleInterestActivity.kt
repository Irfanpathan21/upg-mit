package com.uianp308p.lab.set1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.uianp308p.lab.R

class Q01SimpleInterestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q01_simple_interest)

        val etPrincipal = findViewById<EditText>(R.id.etPrincipal)
        val etRate = findViewById<EditText>(R.id.etRate)
        val etTime = findViewById<EditText>(R.id.etTime)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val tvSI = findViewById<TextView>(R.id.tvSimpleInterest)
        val tvTotal = findViewById<TextView>(R.id.tvTotalAmount)

        btnCalculate.setOnClickListener {
            val pStr = etPrincipal.text.toString().trim()
            val rStr = etRate.text.toString().trim()
            val tStr = etTime.text.toString().trim()

            if (pStr.isEmpty() || rStr.isEmpty() || tStr.isEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.dialog_error_title))
                    .setMessage(getString(R.string.q01_error_empty))
                    .setPositiveButton(getString(R.string.dialog_ok), null)
                    .show()
                return@setOnClickListener
            }

            val p = pStr.toDoubleOrNull() ?: 0.0
            val r = rStr.toDoubleOrNull() ?: 0.0
            val t = tStr.toDoubleOrNull() ?: 0.0

            val si = (p * r * t) / 100.0
            val total = p + si

            tvSI.text = "Simple Interest (SI): ₹ ${String.format("%.2f", si)}"
            tvTotal.text = "Total Amount (P + SI): ₹ ${String.format("%.2f", total)}"
        }

        btnReset.setOnClickListener {
            etPrincipal.text.clear()
            etRate.text.clear()
            etTime.text.clear()
            tvSI.text = getString(R.string.q01_si_label)
            tvTotal.text = getString(R.string.q01_total_label)
        }
    }
}
