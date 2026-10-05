package com.uianp308p.lab.set2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.uianp308p.lab.R

class Q09FloatingCounterActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q09_floating_counter)

        val coordinator = findViewById<CoordinatorLayout>(R.id.coordinatorRoot)
        val tvCount = findViewById<TextView>(R.id.tvCounterValue)
        val fab = findViewById<FloatingActionButton>(R.id.fabCounter)

        fab.setOnClickListener {
            count++
            if (count >= 10) {
                AlertDialog.Builder(this)
                    .setTitle("Limit Reached")
                    .setMessage(getString(R.string.q09_limit_reached))
                    .setPositiveButton(getString(R.string.dialog_ok)) { _, _ ->
                        count = 0
                        tvCount.text = count.toString()
                    }
                    .setCancelable(false)
                    .show()
            } else {
                tvCount.text = count.toString()
                Snackbar.make(coordinator, "Count increased to $count", Snackbar.LENGTH_SHORT)
                    .setAction(getString(R.string.q09_undo)) {
                        if (count > 0) count--
                        tvCount.text = count.toString()
                    }
                    .show()
            }
        }
    }
}
