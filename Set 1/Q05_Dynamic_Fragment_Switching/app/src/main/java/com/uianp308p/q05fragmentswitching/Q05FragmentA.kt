package com.uianp308p.q05fragmentswitching

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.uianp308p.q05fragmentswitching.R

class Q05FragmentA : Fragment() {

    private val tag = "FragmentA"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(tag, "onAttach() called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate() called")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        Log.d(tag, "onCreateView() called")
        val view = inflater.inflate(R.layout.fragment_q05_a, container, false)
        val etName = view.findViewById<EditText>(R.id.etFragName)
        val etEmail = view.findViewById<EditText>(R.id.etFragEmail)
        val btnSave = view.findViewById<Button>(R.id.btnSaveFragment)

        btnSave.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            (activity as? Q05DynamicFragmentActivity)?.saveData(name, email)
            Toast.makeText(context, "Data Saved to Fragment B!", Toast.LENGTH_SHORT).show()
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause() called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(tag, "onDestroyView() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy() called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(tag, "onDetach() called")
    }
}
