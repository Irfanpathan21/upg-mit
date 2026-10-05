package com.uianp308p.q18appbarmenu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.uianp308p.q18appbarmenu.R

class Q18AppBarMenuActivity : AppCompatActivity() {

    private lateinit var rootLayout: LinearLayout
    private lateinit var tvMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q18_appbar_menu)

        val toolbar = findViewById<Toolbar>(R.id.q18Toolbar)
        setSupportActionBar(toolbar)

        rootLayout = findViewById(R.id.rootAppBarScreen)
        tvMessage = findViewById(R.id.tvAppBarMessage)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_q18, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_color_red -> {
                rootLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.theme_red_bg))
                tvMessage.text = "Applied Color Theme: Soft Red"
                true
            }
            R.id.menu_color_green -> {
                rootLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.theme_green_bg))
                tvMessage.text = "Applied Color Theme: Soft Green"
                true
            }
            R.id.menu_color_blue -> {
                rootLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.theme_blue_bg))
                tvMessage.text = "Applied Color Theme: Soft Blue"
                true
            }
            R.id.menu_reset -> {
                rootLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.screen_background))
                tvMessage.text = getString(R.string.q18_center_message)
                true
            }
            R.id.menu_exit -> {
                AlertDialog.Builder(this)
                    .setTitle("Confirm Exit")
                    .setMessage(R.string.dialog_exit_message)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("Yes") { _, _ ->
                        finish()
                    }
                    .setNegativeButton("No", null)
                    .show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
