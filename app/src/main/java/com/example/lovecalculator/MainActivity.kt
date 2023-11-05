package com.example.lovecalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lovecalculator.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        with(binding){
            calculateBtn.setOnClickListener {
                RetrofitService().api.getPercentage(
                    firstEd.text.toString(),
                    secondEd.text.toString()
                ).enqueue(object : retrofit2.Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful) {
                            val loveModel = response.body()
                            if (loveModel != null) {
                                val intent = Intent(this@MainActivity, ResultActivity::class.java)
                                intent.putExtra("firstname", loveModel.firstname)
                                intent.putExtra("secondname", loveModel.secondname)
                                intent.putExtra("percentage", loveModel.percentage)
                                intent.putExtra("result",loveModel.result)
                                startActivity(intent)
                            } else {
                                // Обработка ошибки разбора ответа
                            }
                        } else {
                            // Обработка ошибки HTTP-запроса
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.d("ololo", "onFailure: ${t.message}")
                    }
                })
            }
        }
    }
}