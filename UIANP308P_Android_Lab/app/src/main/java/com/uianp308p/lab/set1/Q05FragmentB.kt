package com.uianp308p.lab.set1

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.uianp308p.lab.R

class Q05FragmentB : Fragment() {

    private val tag = "FragmentB"
    private var name: String = "(Not Saved)"
    private var email: String = "(Not Saved)"

    companion object {
        fun newInstance(name: String, email: String): Q05FragmentB {
            val frag = Q05FragmentB()
            val args = Bundle().apply {
                putString("NAME", name)
                putString("EMAIL", email)
            }
            frag.arguments = args
            return frag
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(tag, "onAttach() called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate() called")
        name = arguments?.getString("NAME") ?: "(Not Saved)"
        email = arguments?.getString("EMAIL") ?: "(Not Saved)"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        Log.d(tag, "onCreateView() called")
        val view = inflater.inflate(R.layout.fragment_q05_b, container, false)
        view.findViewById<TextView>(R.id.tvDisplaySavedName).text = "Saved Name: $name"
        view.findViewById<TextView>(R.id.tvDisplaySavedEmail).text = "Saved Email: $email"
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
