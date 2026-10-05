package com.uianp308p.q20backgroundservice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.uianp308p.q20backgroundservice.R

class Q20BackgroundServiceActivity : AppCompatActivity() {

    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q20_background_service)

        tvStatus = findViewById(R.id.tvServiceStatus)
        val btnStart = findViewById<Button>(R.id.btnStartService)
        val btnStop = findViewById<Button>(R.id.btnStopService)

        updateStatus()

        btnStart.setOnClickListener {
            val serviceIntent = Intent(this, Q20MyBackgroundService::class.java)
            ContextCompat.startForegroundService(this, serviceIntent)
            Q20MyBackgroundService.isServiceRunning = true
            updateStatus()
        }

        btnStop.setOnClickListener {
            if (!Q20MyBackgroundService.isServiceRunning) {
                AlertDialog.Builder(this)
                    .setTitle(R.string.dialog_error_title)
                    .setMessage(R.string.q20_not_running_alert)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton(R.string.dialog_ok, null)
                    .show()
            } else {
                val serviceIntent = Intent(this, Q20MyBackgroundService::class.java)
                stopService(serviceIntent)
                Q20MyBackgroundService.isServiceRunning = false
                updateStatus()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        updateStatus()
    }

    private fun updateStatus() {
        if (Q20MyBackgroundService.isServiceRunning) {
            tvStatus.text = getString(R.string.q20_service_running)
            tvStatus.setTextColor(ContextCompat.getColor(this, R.color.color_success))
        } else {
            tvStatus.text = getString(R.string.q20_service_stopped)
            tvStatus.setTextColor(ContextCompat.getColor(this, R.color.color_error))
        }
    }
}
