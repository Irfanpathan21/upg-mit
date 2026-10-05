package com.uianp308p.lab.set4

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.uianp308p.lab.R

class Q17DynamicFragmentManagementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q17_fragment_management)

        val btnAdd = findViewById<Button>(R.id.btnFragAdd)
        val btnReplace = findViewById<Button>(R.id.btnFragReplace)
        val btnRemove = findViewById<Button>(R.id.btnFragRemove)

        btnAdd.setOnClickListener {
            val frag1 = Q17Fragment1()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, frag1, Q17Fragment1.TAG)
                .commit()
            Toast.makeText(this, "Added Fragment 1", Toast.LENGTH_SHORT).show()
        }

        btnReplace.setOnClickListener {
            val frag2 = Q17Fragment2()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, frag2, Q17Fragment2.TAG)
                .commit()
            Toast.makeText(this, "Replaced with Fragment 2", Toast.LENGTH_SHORT).show()
        }

        btnRemove.setOnClickListener {
            val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
            if (currentFragment != null) {
                supportFragmentManager.beginTransaction()
                    .remove(currentFragment)
                    .commit()
                Toast.makeText(this, "Fragment removed", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, R.string.q17_no_frag_toast, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
