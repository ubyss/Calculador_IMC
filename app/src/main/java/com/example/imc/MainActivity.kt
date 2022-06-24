package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_calculate.setOnClickListener {
            if (pt_height.text.isNullOrEmpty() || pt_weight.text.isNullOrEmpty()){
                Toast.makeText(this, "Você precisa preencher todos os campos", Toast.LENGTH_LONG).show()
            } else {
                var weight = pt_weight.text.toString()
                var height = pt_height.text.toString()
                var result: Double = weight.toDouble() /  (height.toDouble() * height.toDouble())
                when{
                    result < 16 -> tv_result.text = "Você está com Magreza grave"
                    result in 16.0..17.0 -> tv_result.text = "Você está com Magreza moderada"
                    result in 17.0..18.5 -> tv_result.text = "Você está com Magreza leve"
                    result in 18.5..25.0 -> tv_result.text = "Você está com Saúdavel"
                    result in 25.0..30.0 -> tv_result.text = "Você está com Sobrepeso"
                    result in 30.0..35.0 -> tv_result.text = "Você está com Obesidade Grau I"
                    result in 30.0..40.0 -> tv_result.text = "Você está com Obesidade Grau II (severa)"
                    result > 40 -> tv_result.text = "Você está com Obesidade Grau III (mórbida)"
                }
            }
        }
    }
}

