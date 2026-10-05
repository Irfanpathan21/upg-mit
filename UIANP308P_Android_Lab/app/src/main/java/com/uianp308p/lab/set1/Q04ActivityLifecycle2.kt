package com.uianp308p.lab.set1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.uianp308p.lab.R

class Q04ActivityLifecycle2 : AppCompatActivity() {

    private val tag = "LifecycleActivity2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q04_lifecycle2)
        logAndToast("onCreate() called")

        val name = intent.getStringExtra("USER_NAME") ?: "Guest"
        findViewById<TextView>(R.id.tvWelcomeName).text = getString(R.string.q04_welcome_prefix, name)

        findViewById<Button>(R.id.btnBackActivity).setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        logAndToast("onStart() called")
    }

    override fun onResume() {
        super.onResume()
        logAndToast("onResume() called")
    }

    override fun onPause() {
        super.onPause()
        logAndToast("onPause() called")
    }

    override fun onStop() {
        super.onStop()
        logAndToast("onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        logAndToast("onDestroy() called")
    }

    private fun logAndToast(msg: String) {
        Log.d(tag, msg)
        Toast.makeText(this, "Act2: $msg", Toast.LENGTH_SHORT).show()
    }
}
