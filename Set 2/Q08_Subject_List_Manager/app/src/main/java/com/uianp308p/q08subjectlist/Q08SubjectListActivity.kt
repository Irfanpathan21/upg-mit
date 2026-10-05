package com.uianp308p.q08subjectlist

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.uianp308p.q08subjectlist.R

class Q08SubjectListActivity : AppCompatActivity() {

    private val subjects = arrayListOf(
        "Android Programming",
        "Data Structures",
        "Operating Systems",
        "Computer Networks",
        "Database Management",
        "Web Technologies"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q08_subject_list)

        val etSubject = findViewById<EditText>(R.id.etSubjectName)
        val btnAdd = findViewById<Button>(R.id.btnAddSubject)
        val lv = findViewById<ListView>(R.id.lvSubjects)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, subjects)
        lv.adapter = adapter

        btnAdd.setOnClickListener {
            val text = etSubject.text.toString().trim()
            if (text.isEmpty()) {
                Toast.makeText(this, "Please enter subject name!", Toast.LENGTH_SHORT).show()
            } else {
                subjects.add(text)
                adapter.notifyDataSetChanged()
                etSubject.text.clear()
                Toast.makeText(this, "Subject added!", Toast.LENGTH_SHORT).show()
            }
        }

        lv.setOnItemLongClickListener { _, _, position, _ ->
            val item = subjects[position]
            AlertDialog.Builder(this)
                .setTitle("Confirm Deletion")
                .setMessage(getString(R.string.q08_delete_confirm, item))
                .setPositiveButton(getString(R.string.dialog_yes)) { _, _ ->
                    subjects.removeAt(position)
                    adapter.notifyDataSetChanged()
                    Toast.makeText(this, "Subject deleted", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton(getString(R.string.dialog_no), null)
                .show()
            true
        }
    }
}
