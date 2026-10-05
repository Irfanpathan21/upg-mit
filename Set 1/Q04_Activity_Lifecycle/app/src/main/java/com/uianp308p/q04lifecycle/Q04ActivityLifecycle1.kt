package com.uianp308p.q04lifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.uianp308p.q04lifecycle.R

class Q04ActivityLifecycle1 : AppCompatActivity() {

    private val tag = "LifecycleActivity1"
    private var resumeCount = 0
    private lateinit var tvResumeCount: TextView
    private lateinit var tvLog: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q04_lifecycle1)
        logAndToast("onCreate() called")

        tvResumeCount = findViewById(R.id.tvResumedCount)
        tvLog = findViewById(R.id.tvLifecycleLog1)
        val etName = findViewById<EditText>(R.id.etUserName)
        val btnNext = findViewById<Button>(R.id.btnNextActivity)

        btnNext.setOnClickListener {
            val name = etName.text.toString().trim()
            val intent = Intent(this, Q04ActivityLifecycle2::class.java).apply {
                putExtra("USER_NAME", if (name.isEmpty()) "Guest" else name)
            }
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        logAndToast("onStart() called")
    }

    override fun onResume() {
        super.onResume()
        resumeCount++
        tvResumeCount.text = getString(R.string.q04_resumed_count, resumeCount)
        logAndToast("onResume() called [Resumed: $resumeCount times]")
    }

    override fun onPause() {
        super.onPause()
        logAndToast("onPause() called")
    }

    override fun onStop() {
        super.onStop()
        logAndToast("onStop() called")
    }

    override fun onRestart() {
        super.onRestart()
        logAndToast("onRestart() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        logAndToast("onDestroy() called")
    }

    private fun logAndToast(msg: String) {
        Log.d(tag, msg)
        Toast.makeText(this, "Act1: $msg", Toast.LENGTH_SHORT).show()
    }
}
