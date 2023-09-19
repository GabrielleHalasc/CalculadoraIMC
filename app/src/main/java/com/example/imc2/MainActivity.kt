package com.example.imc2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.gabi.calculadoraimc.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tietPeso: TextInputEditText = findViewById(R.id.tiet_peso)
        val tietAltura: TextInputEditText = findViewById(R.id.tiet_altura)
        val btnCalcular: Button = findViewById(R.id.btn_calcular)
        val tilAltura: TextInputLayout = findViewById(R.id.til_altura)
        val tilPeso: TextInputLayout = findViewById(R.id.til_peso)

        btnCalcular.setOnClickListener {
            val alturaString = tietAltura.text.toString()
            val pesoString = tietPeso.text.toString()


            if (alturaString.isEmpty()) {
                tilAltura.error = "*Altura obrigatória"
            } else {
                tilAltura.error = null
                tilAltura.isErrorEnabled = false
            }
            if (pesoString.isEmpty()) {
                tilPeso.error = "*Peso obrigatório"
            } else {
                tilPeso.error = null
                tilPeso.isErrorEnabled = false
            }


            if (alturaString.isNotEmpty() && pesoString.isNotEmpty()) {
                val altura: Float = tietAltura.text.toString().toFloat()
                val peso: Float = tietPeso.text.toString().toFloat()

                val alturafinal: Float = altura * altura
                val resultado: Float = peso / alturafinal

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("Extra_result", resultado)
                        putExtra("Extra_altura", altura)
                        putExtra("Extra_peso", peso)
                    }
                startActivity(intent)

            }

        }
    }
}