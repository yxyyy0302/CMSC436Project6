package com.example.project6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class DeleteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val radioGroup = RadioGroup(this)
        for (candy in MainActivity.candies) {
            val rb = RadioButton(this)
            rb.text = candy.getName()

            rb.setOnClickListener {
                ServerTaskDelete(candy.getId()).start()
                MainActivity.candies.remove(candy)
                recreate()
            }
            radioGroup.addView(rb)
        }

        val backButton = Button(this)
        backButton.text = "BACK"
        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        layout.addView(radioGroup)
        layout.addView(backButton)
        setContentView(layout)
    }
}
