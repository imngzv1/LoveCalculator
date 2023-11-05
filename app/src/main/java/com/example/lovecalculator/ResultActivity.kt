package com.example.lovecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lovecalculator.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstname = intent.getStringExtra("firstname")
        val secondname = intent.getStringExtra("secondname")
        val percentage = intent.getStringExtra("percentage")
        val result= intent.getStringExtra("result")

        val resultText = "$firstname\n $secondname\n $percentage $result"
        binding.resultTv.text = resultText
    }
}
