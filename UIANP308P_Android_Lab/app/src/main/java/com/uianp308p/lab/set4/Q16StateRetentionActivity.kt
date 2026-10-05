package com.uianp308p.lab.set4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.uianp308p.lab.R

class Q16StateRetentionActivity : AppCompatActivity() {

    private var counter: Int = 0
    private lateinit var tvCounter: TextView

    companion object {
        private const val KEY_COUNTER = "key_counter_value"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q16_state_retention)

        tvCounter = findViewById(R.id.tvCounterValue)
        val btnIncrement = findViewById<Button>(R.id.btnIncrement)
        val btnDecrement = findViewById<Button>(R.id.btnDecrement)

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(KEY_COUNTER, 0)
        }
        updateDisplay()

        btnIncrement.setOnClickListener {
            counter++
            updateDisplay()
        }

        btnDecrement.setOnClickListener {
            if (counter <= 0) {
                AlertDialog.Builder(this)
                    .setTitle(R.string.dialog_error_title)
                    .setMessage(R.string.q16_neg_alert)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton(R.string.dialog_ok, null)
                    .show()
                counter = 0
            } else {
                counter--
            }
            updateDisplay()
        }
    }

    private fun updateDisplay() {
        tvCounter.text = counter.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNTER, counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counter = savedInstanceState.getInt(KEY_COUNTER, 0)
        updateDisplay()
    }
}
