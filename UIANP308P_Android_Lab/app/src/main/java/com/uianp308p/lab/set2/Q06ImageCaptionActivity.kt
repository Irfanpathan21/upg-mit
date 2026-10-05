package com.uianp308p.lab.set2

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.uianp308p.lab.R

class Q06ImageCaptionActivity : AppCompatActivity() {

    private val colors = arrayOf(
        Color.parseColor("#B31A237E"), // Translucent Indigo
        Color.parseColor("#B32E7D32"), // Translucent Green
        Color.parseColor("#B3E64A19")  // Translucent Deep Orange
    )
    private var colorIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q06_image_caption)

        val tvCaption = findViewById<TextView>(R.id.tvCaption)
        val btnToggle = findViewById<Button>(R.id.btnToggleCaption)
        val btnColor = findViewById<Button>(R.id.btnChangeColor)
        val btnExit = findViewById<Button>(R.id.btnExitApp)

        btnToggle.setOnClickListener {
            tvCaption.visibility = if (tvCaption.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        }

        btnColor.setOnClickListener {
            colorIndex = (colorIndex + 1) % colors.size
            tvCaption.setBackgroundColor(colors[colorIndex])
        }

        btnExit.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.btn_exit))
                .setMessage(getString(R.string.q06_exit_confirm))
                .setPositiveButton(getString(R.string.dialog_yes)) { _, _ -> finish() }
                .setNegativeButton(getString(R.string.dialog_no), null)
                .show()
        }
    }
}
