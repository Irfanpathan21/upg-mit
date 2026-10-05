package com.uianp308p.lab.set2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.uianp308p.lab.R

class Q10RegistrationActivity : AppCompatActivity() {

    private val cities = arrayOf("Mumbai", "Delhi", "Bengaluru", "Pune", "Hyderabad")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q10_registration)

        val toolbar = findViewById<Toolbar>(R.id.toolbarReg)
        toolbar.setNavigationOnClickListener { finish() }

        val etName = findViewById<EditText>(R.id.etRegName)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val cbReading = findViewById<CheckBox>(R.id.cbReading)
        val cbCoding = findViewById<CheckBox>(R.id.cbCoding)
        val cbSports = findViewById<CheckBox>(R.id.cbSports)
        val spCity = findViewById<Spinner>(R.id.spCity)
        val btnSubmit = findViewById<Button>(R.id.btnRegSubmit)

        val cityAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, cities)
        spCity.adapter = cityAdapter

        btnSubmit.setOnClickListener {
            val name = etName.text.toString().trim()
            val genderId = rgGender.checkedRadioButtonId

            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter your name!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (genderId == -1) {
                Toast.makeText(this, "Please select your gender!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val gender = if (genderId == R.id.rbMale) "Male" else "Female"
            val hobbies = mutableListOf<String>()
            if (cbReading.isChecked) hobbies.add("Reading")
            if (cbCoding.isChecked) hobbies.add("Coding")
            if (cbSports.isChecked) hobbies.add("Sports")
            val hobbiesStr = if (hobbies.isEmpty()) "None" else hobbies.joinToString(", ")
            val city = spCity.selectedItem.toString()

            val summary = "Name: $name\nGender: $gender\nHobbies: $hobbiesStr\nCity: $city"

            AlertDialog.Builder(this)
                .setTitle("Registration Successful")
                .setMessage(summary)
                .setPositiveButton(getString(R.string.dialog_ok), null)
                .show()
        }
    }
}
