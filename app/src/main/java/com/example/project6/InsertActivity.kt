package com.example.project6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project6.databinding.ActivityInsertBinding
import com.example.project6.databinding.ActivityMainBinding

class InsertActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInsertBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            finish()
        }

    }
}
