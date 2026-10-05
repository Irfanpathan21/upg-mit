package com.uianp308p.q05fragmentswitching

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.uianp308p.q05fragmentswitching.R

class Q05DynamicFragmentActivity : AppCompatActivity() {

    private var savedName: String = ""
    private var savedEmail: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q05_fragment_switching)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, Q05FragmentA())
                .commit()
        }

        findViewById<Button>(R.id.btnShowFragmentA).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, Q05FragmentA())
                .commit()
        }

        findViewById<Button>(R.id.btnShowFragmentB).setOnClickListener {
            val fragB = Q05FragmentB.newInstance(
                if (savedName.isEmpty()) "(Not Saved)" else savedName,
                if (savedEmail.isEmpty()) "(Not Saved)" else savedEmail
            )
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragB)
                .commit()
        }
    }

    fun saveData(name: String, email: String) {
        this.savedName = name
        this.savedEmail = email
    }
}
