package com.uianp308p.lab.set3

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.uianp308p.lab.R

class Q15MultiplicationTableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q15_multiplication_table)

        val etNumber = findViewById<EditText>(R.id.etTableNumber)
        val btnGenerate = findViewById<Button>(R.id.btnGenerateTable)
        val btnClear = findViewById<Button>(R.id.btnClearTable)
        val tableLayout = findViewById<TableLayout>(R.id.tableLayout)

        btnGenerate.setOnClickListener {
            val numStr = etNumber.text.toString().trim()
            val number = numStr.toIntOrNull()

            if (number == null || number == 0) {
                AlertDialog.Builder(this)
                    .setTitle(R.string.dialog_error_title)
                    .setMessage(R.string.q15_err_zero)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton(R.string.dialog_ok, null)
                    .show()
                return@setOnClickListener
            }

            tableLayout.removeAllViews()

            // Header row
            val headerRow = TableRow(this)
            headerRow.setBackgroundColor(ContextCompat.getColor(this, R.color.primary))
            val headers = arrayOf("Number", "×", "Multiplier", "=", "Result")
            for (header in headers) {
                val tv = TextView(this).apply {
                    text = header
                    setTextColor(Color.WHITE)
                    gravity = Gravity.CENTER
                    setPadding(12, 16, 12, 16)
                    textSize = 14f
                    paint.isFakeBoldText = true
                }
                headerRow.addView(tv)
            }
            tableLayout.addView(headerRow)

            // Multiples 1 to 10 with alternating row colors
            for (i in 1..10) {
                val row = TableRow(this)
                val bgColor = if (i % 2 == 0) ContextCompat.getColor(this, R.color.color_table_row_alt) else Color.WHITE
                row.setBackgroundColor(bgColor)

                val cols = arrayOf(
                    number.toString(),
                    "×",
                    i.toString(),
                    "=",
                    (number * i).toString()
                )

                for (c in cols) {
                    val tv = TextView(this).apply {
                        text = c
                        setTextColor(ContextCompat.getColor(this@Q15MultiplicationTableActivity, R.color.text_primary))
                        gravity = Gravity.CENTER
                        setPadding(12, 14, 12, 14)
                        textSize = 15f
                    }
                    row.addView(tv)
                }
                tableLayout.addView(row)
            }
        }

        btnClear.setOnClickListener {
            tableLayout.removeAllViews()
            etNumber.text.clear()
        }
    }
}
