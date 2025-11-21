package com.example.project6

import android.os.Bundle
import android.widget.Toast
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

        binding.add.setOnClickListener {
            val name = binding.candyName.text.toString()
            val priceText = binding.candyPrice.text.toString()


            val price = priceText.toDouble()


            // Start the server task to insert candy
            ServerTaskInsert(name, price).start()

            // Optional: clear input fields after insert
            binding.candyName.text.clear()
            binding.candyPrice.text.clear()
        }

    }
}
