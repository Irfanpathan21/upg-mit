package com.uianp308p.lab

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.uianp308p.lab.set1.*
import com.uianp308p.lab.set2.*
import com.uianp308p.lab.set3.*
import com.uianp308p.lab.set4.*

data class PracticalItem(
    val qNumber: String,
    val title: String,
    val description: String,
    val targetClass: Class<out AppCompatActivity>
)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container = findViewById<LinearLayout>(R.id.llPracticalsContainer)
        val inflater = LayoutInflater.from(this)

        val practicalsMap = mapOf(
            "SET 1: PRACTICAL QUESTIONS 1 TO 5" to listOf(
                PracticalItem("Q01", "Simple Interest Calculator", "LinearLayout (Vertical) with AlertDialog validation and dimensions", Q01SimpleInterestActivity::class.java),
                PracticalItem("Q02", "Login Screen with Custom Theme", "RelativeLayout with Custom Theme and Rounded Login Button", Q02LoginActivity::class.java),
                PracticalItem("Q03", "Student Result Calculator", "TableLayout with 4 Subjects, Total, %, Grade and Pass/Fail Badge", Q03StudentResultActivity::class.java),
                PracticalItem("Q04", "Activity Lifecycle & Navigation", "Two activities logging onResume/onPause with Logcat & Toast", Q04ActivityLifecycle1::class.java),
                PracticalItem("Q05", "Dynamic Fragment Communication", "Two buttons switching Fragment A and Fragment B with message passing", Q05DynamicFragmentActivity::class.java)
            ),
            "SET 2: PRACTICAL QUESTIONS 6 TO 10" to listOf(
                PracticalItem("Q06", "Image Caption Screen", "FrameLayout with overlapping text caption and toggle button", Q06ImageCaptionActivity::class.java),
                PracticalItem("Q07", "GridView Color Palette", "GridView with 12 distinct colors in 3 columns and preview banner", Q07GridViewPaletteActivity::class.java),
                PracticalItem("Q08", "Subject List Manager", "ListView with Add and Delete Confirmation AlertDialog", Q08SubjectListActivity::class.java),
                PracticalItem("Q09", "Floating Counter with CoordinatorLayout", "CoordinatorLayout, FAB, SnackBar with Undo & Limit of 10", Q09FloatingCounterActivity::class.java),
                PracticalItem("Q10", "Registration Form with AppBar", "Toolbar, RadioGroup, CheckBoxes, Spinner and summary Toast", Q10RegistrationActivity::class.java)
            ),
            "SET 3: PRACTICAL QUESTIONS 11 TO 15" to listOf(
                PracticalItem("Q11", "Temperature Converter", "LinearLayout Celsius to Fahrenheit & reverse with distinct colors", Q11TemperatureConverterActivity::class.java),
                PracticalItem("Q12", "Feedback Screen", "AbsoluteLayout coordinates for Name, Comments & Validation Alert", Q12FeedbackActivity::class.java),
                PracticalItem("Q13", "Rating Screen", "RelativeLayout RatingBar with conditional Toast or Inquiry Alert", Q13RatingScreenActivity::class.java),
                PracticalItem("Q14", "Profile Card Dynamic Themes", "LinearLayout Profile Card with Light/Dark Mode toggle & Contact details", Q14ProfileCardActivity::class.java),
                PracticalItem("Q15", "Multiplication Table Generator", "TableLayout 1 to 10 multiples with alternating row background colors", Q15MultiplicationTableActivity::class.java)
            ),
            "SET 4: PRACTICAL QUESTIONS 16 TO 20" to listOf(
                PracticalItem("Q16", "State Retention Across Lifecycle", "Counter retained with onSaveInstanceState and negative guards", Q16StateRetentionActivity::class.java),
                PracticalItem("Q17", "Dynamic Fragment Management", "Add Frag 1 (Blue), Replace Frag 2 (Green), Remove & Logcat logs", Q17DynamicFragmentManagementActivity::class.java),
                PracticalItem("Q18", "AppBar with Menus & Submenus", "Toolbar Options Menu, Red/Green/Blue theme submenu & Exit dialog", Q18AppBarMenuActivity::class.java),
                PracticalItem("Q19", "Inter-Activity Data Passing", "Intent extras bundle passing Name, Age, City and Adult/Minor badge", Q19DataPassingActivity1::class.java),
                PracticalItem("Q20", "Background Service & Notifications", "Foreground Service with system notification and Running/Stopped state", Q20BackgroundServiceActivity::class.java)
            )
        )

        for ((sectionTitle, items) in practicalsMap) {
            val headerView = inflater.inflate(R.layout.item_section_header, container, false) as TextView
            headerView.text = sectionTitle
            container.addView(headerView)

            for (item in items) {
                val cardView = inflater.inflate(R.layout.item_practical_card, container, false)
                val tvBadge = cardView.findViewById<TextView>(R.id.tvBadge)
                val tvTitle = cardView.findViewById<TextView>(R.id.tvPracticalTitle)
                val tvDesc = cardView.findViewById<TextView>(R.id.tvPracticalDesc)
                val btnLaunch = cardView.findViewById<Button>(R.id.btnLaunchPractical)

                tvBadge.text = item.qNumber
                tvTitle.text = item.title
                tvDesc.text = item.description

                btnLaunch.setOnClickListener {
                    val intent = Intent(this, item.targetClass)
                    startActivity(intent)
                }

                container.addView(cardView)
            }
        }
    }
}
