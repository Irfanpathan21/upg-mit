package com.uianp308p.lab.set2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.uianp308p.lab.R

class Q07GridViewPaletteActivity : AppCompatActivity() {

    data class ColorItem(val name: String, val colorRes: Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q07_grid_view)

        val palette = listOf(
            ColorItem("Red", R.color.pal_red),
            ColorItem("Pink", R.color.pal_pink),
            ColorItem("Purple", R.color.pal_purple),
            ColorItem("Indigo", R.color.pal_indigo),
            ColorItem("Blue", R.color.pal_blue),
            ColorItem("Teal", R.color.pal_teal),
            ColorItem("Green", R.color.pal_green),
            ColorItem("Lime", R.color.pal_lime),
            ColorItem("Amber", R.color.pal_amber),
            ColorItem("Orange", R.color.pal_orange),
            ColorItem("Deep Orange", R.color.pal_deep_orange),
            ColorItem("Brown", R.color.pal_brown)
        )

        val gv = findViewById<GridView>(R.id.gvColors)
        val banner = findViewById<TextView>(R.id.tvSelectedColorBanner)

        gv.adapter = object : BaseAdapter() {
            override fun getCount(): Int = palette.size
            override fun getItem(position: Int): Any = palette[position]
            override fun getItemId(position: Int): Long = position.toLong()

            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val view = convertView ?: LayoutInflater.from(this@Q07GridViewPaletteActivity)
                    .inflate(R.layout.item_color_grid, parent, false)
                val item = palette[position]
                val tv = view.findViewById<TextView>(R.id.tvGridColorItem)
                tv.text = item.name
                val color = ContextCompat.getColor(this@Q07GridViewPaletteActivity, item.colorRes)
                tv.setBackgroundColor(color)
                return view
            }
        }

        gv.setOnItemClickListener { _, _, position, _ ->
            val item = palette[position]
            val color = ContextCompat.getColor(this, item.colorRes)
            Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show()
            banner.setBackgroundColor(color)
            banner.text = "Selected: ${item.name}"
        }

        gv.setOnItemLongClickListener { _, _, position, _ ->
            val item = palette[position]
            AlertDialog.Builder(this)
                .setTitle("Color Cell Details")
                .setMessage("Color: ${item.name}\nGrid Position: #${position + 1} (Row ${(position / 3) + 1}, Col ${(position % 3) + 1})")
                .setPositiveButton(getString(R.string.dialog_ok), null)
                .show()
            true
        }
    }
}
