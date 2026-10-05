package com.uianp308p.lab.set3

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.uianp308p.lab.R

class Q14ProfileCardActivity : AppCompatActivity() {

    private var isDarkMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q14_profile_card)

        val rootLayout = findViewById<LinearLayout>(R.id.rootProfileLayout)
        val card = findViewById<LinearLayout>(R.id.cardProfileContainer)
        val tvHeader = findViewById<TextView>(R.id.tvProfileHeader)
        val tvName = findViewById<TextView>(R.id.tvProfileName)
        val tvCourse = findViewById<TextView>(R.id.tvProfileCourse)
        val tvBio = findViewById<TextView>(R.id.tvProfileBio)
        val btnSwitch = findViewById<Button>(R.id.btnSwitchMode)
        val btnContact = findViewById<Button>(R.id.btnContact)

        btnSwitch.setOnClickListener {
            isDarkMode = !isDarkMode
            if (isDarkMode) {
                // Apply Dark Mode
                rootLayout.setBackgroundColor(Color.parseColor("#121212"))
                card.setBackgroundColor(Color.parseColor("#1E1E2E"))
                tvHeader.setTextColor(Color.WHITE)
                tvName.setTextColor(Color.WHITE)
                tvCourse.setTextColor(Color.parseColor("#80D8FF"))
                tvBio.setTextColor(Color.parseColor("#CCCCCC"))
            } else {
                // Apply Light Mode
                rootLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.screen_background))
                card.setBackgroundColor(Color.WHITE)
                tvHeader.setTextColor(ContextCompat.getColor(this, R.color.primary))
                tvName.setTextColor(ContextCompat.getColor(this, R.color.text_primary))
                tvCourse.setTextColor(ContextCompat.getColor(this, R.color.primary))
                tvBio.setTextColor(ContextCompat.getColor(this, R.color.text_secondary))
            }
        }

        btnContact.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Alex Johnson Contact Details")
                .setMessage(getString(R.string.q14_contact_info))
                .setIcon(android.R.drawable.ic_dialog_info)
                .setPositiveButton(R.string.dialog_ok, null)
                .show()
        }
    }
}
