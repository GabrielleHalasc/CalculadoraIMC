package com.example.imc2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.gabi.calculadoraimc.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val txtRating = findViewById<TextView>(R.id.txt_rating)
        val txtResult = findViewById<TextView>(R.id.txt_results)
        val result = intent.getFloatExtra("Extra_result", 0.1f)
        val btnTabela = findViewById<Button>(R.id.btn_tabela)
        val txtDica = findViewById<TextView>(R.id.txt_dica)

        btnTabela.setOnClickListener {
            val intent = Intent(this, TableActivity::class.java)
            startActivity(intent)
        }

        val imgButton = findViewById<ImageButton>(R.id.imgBtn_voltar)

        imgButton.setOnClickListener(View.OnClickListener {
            finish()
        })

        txtResult.text = result.toString()

        var dica = ""

        var rating = ""
        if (result < 18.5) {
            rating = "Abaixo do peso"
            dica = "Busque por alimentos ricos em proteínas e aposte nas gorduras boas como castanhas, abacate e amendoim. Procure um nutricionista."
        } else if (result in 18.5..24.999999) {
            rating = "Peso ideal"
            dica = "Parabéns, você está no peso ideal, continue assim!"
        } else if (result in 25.0..29.9999999) {
            rating = "Sobrepeso"
            dica = "Procure uma reeducação alimentar com alimentos saudáveis e nutritivos, evite comidas gordurosas. Busque acompanhamento nutricional."
        } else if (result in 30.0..34.999999) {
            rating = "Obesidade 1"
            dica = "Evite alimentos pesados tarde da noite, estômago e intestino estão funcionando mais lentamente. Procure um médico."
        } else if (result in 35.0..39.999999) {
            rating = "Obesidade 2 (Severa)"
            dica = "Escolha alimentos naturais, priorize proteínas magras. Busque por um acompanhamento médico e nutricional!"
        } else {
            rating = "Obesity 3 (Morbida)"
            dica = "Escolha alimentos naturais, priorize proteínas magras. Busque por um acompanhamento médico e nutricional!"
        }
        txtDica.text = dica
        txtRating.text = rating
    }

}